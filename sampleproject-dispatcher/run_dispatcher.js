'use strict'

const { execSync } = require('child_process')
const fs = require('fs')

const exec = commands => {
    console.log(commands)
    execSync(commands, {stdio: 'inherit', shell: true})
}

const copyNewFiles = () => {
    const newFiles = [{
        src: './src/conf.d/rewrites/sampleproject_rewrite.rules',
        dst: './out/sampleproject_rewrite_rules'
    },{
        src: './src/conf.dispatcher.d/virtualhosts/sampleproject_virtualhosts.any',
        dst: './out/sampleproject_virtualhosts_any'
    },{
        src: './src/conf.dispatcher.d/clientheaders/sampleproject_clientheaders.any',
        dst: './out/sampleproject_clientheaders_any'
    }]
    for (let idx in newFiles)
        fs.copyFileSync(newFiles[idx]['src'], newFiles[idx]['dst'])
}

const updateValueCsv = () => {
    var valuesCsv = fs.readFileSync('./out/values.csv').toString()
    valuesCsv = valuesCsv.replace('rewrite_rules', 'rewrite_rules,sampleproject_rewrite_rules')
    valuesCsv = valuesCsv.replace('vhosts_conf', 'vhosts_conf,sampleproject_virtualhosts_any')
    valuesCsv = valuesCsv.replace('clientheaders_any', 'clientheaders_any,sampleproject_clientheaders_any')
    fs.writeFileSync('./out/values.csv', valuesCsv)
}

const createFolderIfNotExists = (folder) => {
    if (!fs.existsSync(folder)) {
        fs.mkdirSync(folder)
    }
}

// 0. Check env
const disptcherToolsBinFolder = process.env.DISPATCHER_TOOLS_BIN_FOLDER
var aemHost = process.env.DISPATCHER_TOOLS_AEMHOST
var port = process.env.DISPATCHER_TOOLS_PORT
if(!disptcherToolsBinFolder) {
    console.log('**ERROR** Check environment variables, for example:')
    console.log('DISPATCHER_TOOLS_BIN_FOLDER=/aem-sdk/dispatcher/bin')
    console.log('DISPATCHER_TOOLS_AEMHOST=host.docker.internal:4503')
    console.log('DISPATCHER_TOOLS_PORT=80')
    process.exit(1)
}
if(!aemHost)
    aemHost = 'host.docker.internal:4503'
if(!port)
    port = '80'
const isLinux = process.platform == 'linux'

// 1. Limpa Diretório
exec(isLinux ? `rm -rf out`: `del out /F /Q`)

// 2. Executa validador do dispatcher tools
exec(`${disptcherToolsBinFolder}/validator full -relaxed -d out src`)

// 3. Copia novos arquivos de projeto para o diretório out
copyNewFiles()

// 4. Ajusta o values.csv para incluir os novos arquivos
updateValueCsv()

// 5. Cache folder
createFolderIfNotExists('./cache')

// 6. Executa o docker do dispatcher tools
exec(`${disptcherToolsBinFolder}/docker_run.${isLinux ? 'sh' : 'cmd'} out ${aemHost} ${port}`)