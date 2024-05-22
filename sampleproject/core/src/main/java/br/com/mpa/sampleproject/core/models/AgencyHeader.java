package br.com.mpa.sampleproject.core.models;

import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface AgencyHeader {
    public String getTitle();
    public String getColorTitle();
    public String getBackgroundTitle();
    List<Resource> getLinks();
}