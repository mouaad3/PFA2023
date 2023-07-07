package com.PFA.emsi.service.Organization;

import com.PFA.emsi.Request.OrganizationRequest;
import com.PFA.emsi.model.Organization;

import java.util.List;

public interface OrganizationService {
    public List<Organization> getAllOrganizations();

    public Organization getOrganizationById(Long id);

    public Organization createOrganization(OrganizationRequest organizationRequest);

    public Organization updateOrganization(Long id, OrganizationRequest organizationRequest);

    public void deleteOrganization(Long id);


}
