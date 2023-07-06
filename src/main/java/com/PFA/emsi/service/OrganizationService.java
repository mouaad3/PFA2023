package com.PFA.emsi.service;

import com.PFA.emsi.model.Organization;
import com.PFA.emsi.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Long id, Organization updatedOrganization) {
        Organization organization = getOrganizationById(id);
        if (organization != null) {
            organization.setName(updatedOrganization.getName());
            organization.setDescription(updatedOrganization.getDescription());
            organization.setAddress(updatedOrganization.getAddress());
            organization.setSites(updatedOrganization.getSites());
            organization.setItManager(updatedOrganization.getItManager());
            return organizationRepository.save(organization);
        }
        return null;
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}
