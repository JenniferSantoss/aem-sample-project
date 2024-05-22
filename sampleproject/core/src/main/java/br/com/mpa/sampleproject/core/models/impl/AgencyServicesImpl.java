package br.com.mpa.sampleproject.core.models.impl;

import br.com.mpa.sampleproject.core.models.AgencyServices;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adapters = AgencyServices.class,
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = AgencyServicesImpl.RESOURCE_TYPE
)
public class AgencyServicesImpl implements AgencyServices{
    public static final String RESOURCE_TYPE = "sampleproject/components/agencyservices";

    @ValueMapValue
    private String title;
    @ChildResource
    private List<Resource> cards;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Resource> getCards() {
        return cards;
    }
}
