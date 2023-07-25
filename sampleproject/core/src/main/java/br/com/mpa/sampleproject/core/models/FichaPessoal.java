package br.com.mpa.sampleproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { MeuComponenteAem.class }, resourceType = {
        FichaPessoal.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FichaPessoal {
    protected static final String RESOURCE_TYPE = "sampleproject/components/fichapessoal";

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String nickname;

    @ValueMapValue
    private String idade;

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getIdade() {
        return idade;
    }
}
