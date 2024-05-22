package br.com.mpa.sampleproject.core.models;

import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface AgencyServices {
    public String getTitle();
    List<Resource> getCards();
}