package br.com.mpa.sampleproject.core.models.impl;
import br.com.mpa.sampleproject.core.models.AgencyHeader;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adapters = AgencyHeader.class,
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = AgencyHeaderImpl.RESOURCE_TYPE
)

public class AgencyHeaderImpl implements AgencyHeader {
    public static final String RESOURCE_TYPE = "sampleproject/components/agencyheader";

    @ValueMapValue
    private String title;
    @ValueMapValue
    private String backgroundTitle;
    @ValueMapValue
    private String colorTitle;
    @ChildResource
    private List<Resource> links;

    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getColorTitle() {
        return colorTitle;
    }
    @Override
    public String getBackgroundTitle() {
        return backgroundTitle;
    }
    @Override
    public List<Resource> getLinks() {
        return links;
    }
}
