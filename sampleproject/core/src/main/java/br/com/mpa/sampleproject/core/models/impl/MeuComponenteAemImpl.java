package br.com.mpa.sampleproject.core.models.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import br.com.mpa.sampleproject.core.models.MeuComponenteAem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { MeuComponenteAem.class }, resourceType = {
        MeuComponenteAemImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MeuComponenteAemImpl implements MeuComponenteAem {
    protected static final String RESOURCE_TYPE = "sampleproject/components/meucomponenteaem";

    @ValueMapValue
    private String name;
    @ValueMapValue
    private List<String> occupations;
    @OSGiService
    private ModelFactory modelFactory;
    @Self
    private SlingHttpServletRequest request;
    private Image image;

    @Override
    public String getName() {
        return name;
    }

    private Image getImage() {
        return image;
    }

    @PostConstruct
    private void init() {
        image = modelFactory.getModelFromWrappedRequest(request,
                request.getResource(),
                Image.class);
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isEmpty() {
        final Image componentImage = getImage();

        if (StringUtils.isBlank(name)) {
            // Name is missing, but required
            return true;
        } else if (occupations == null || occupations.isEmpty()) {
            // At least one occupation is required
            return true;
        } else if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
            // A valid image is required
            return true;
        } else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }
}
