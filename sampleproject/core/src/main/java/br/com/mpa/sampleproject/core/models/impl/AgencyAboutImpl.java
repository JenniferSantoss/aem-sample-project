package br.com.mpa.sampleproject.core.models.impl;

import br.com.mpa.sampleproject.core.models.AgencyAbout;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adapters = AgencyAbout.class,
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = AgencyAboutImpl.RESOURCE_TYPE
)
public class AgencyAboutImpl implements AgencyAbout{
    public static final String RESOURCE_TYPE = "sampleproject/components/agencyabout";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String description;
    @ValueMapValue
    private String backgroundContainer;
    @ValueMapValue
    private boolean showButton;
    @ValueMapValue
    private String buttonText;
    @ValueMapValue
    private String buttonLink;
    @ValueMapValue
    private String buttonBackground;
    @ValueMapValue
    private String image;
    @ValueMapValue
    private String alt;
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getBackgroundContainer() {
        return backgroundContainer;
    }
    @Override
    public boolean getShowButton() {
        return false;
    }
    @Override
    public String getButtonText() {
        return buttonText;
    }
    @Override
    public String getButtonLink() {
        return buttonLink;
    }
    @Override
    public String getButtonBackground() {
        return buttonBackground;
    }
    @Override
    public String getImage() {
        return image;
    }
    @Override
    public String getAlt() {
        return alt;
    }
}
