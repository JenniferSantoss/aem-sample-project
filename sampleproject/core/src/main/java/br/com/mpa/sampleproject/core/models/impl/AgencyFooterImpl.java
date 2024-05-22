package br.com.mpa.sampleproject.core.models.impl;

import br.com.mpa.sampleproject.core.models.AgencyFooter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adapters = AgencyFooter.class,
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = AgencyFooterImpl.RESOURCE_TYPE
)
public class AgencyFooterImpl implements AgencyFooter {
    public static final String RESOURCE_TYPE = "sampleproject/components/agencyfooter";

    @ValueMapValue
    private String title;

    @Override
    public String getTitle() {
        return title;
    }
}
