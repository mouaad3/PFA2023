package com.PFA.emsi.service.Organization;

import com.PFA.emsi.Request.OrganizationRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Organization;
import com.PFA.emsi.model.Site;
import com.PFA.emsi.model.User;
import com.PFA.emsi.repository.OrganizationRepository;
import com.PFA.emsi.repository.SiteRepository;
import com.PFA.emsi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final SiteRepository siteRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, UserRepository userRepository, SiteRepository siteRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with ID: " + id));
    }

    public Organization createOrganization(OrganizationRequest organizationRequest) {
        Organization organization = new Organization();
        organization.setName(organizationRequest.getName());
        organization.setDescription(organizationRequest.getDescription());
        organization.setAddress(organizationRequest.getAddress());

        // Set the IT Manager
        if (organizationRequest.getItManagerId() != null) {
            User itManager = userRepository.findById(organizationRequest.getItManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + organizationRequest.getItManagerId()));
            organization.setItManager(itManager);
        }

        // Set the Sites
        if (organizationRequest.getSiteIds() != null && !organizationRequest.getSiteIds().isEmpty()) {
            List<Site> sites = siteRepository.findAllById(organizationRequest.getSiteIds());
            organization.setSites(sites);
        }

        return organizationRepository.save(organization);
    }


    public Organization updateOrganization(Long id, OrganizationRequest organizationRequest) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with ID: " + id));

        // Update the organization attributes
        if (organizationRequest.getName() != null) {
            organization.setName(organizationRequest.getName());
        }
        if (organizationRequest.getDescription() != null) {
            organization.setDescription(organizationRequest.getDescription());
        }
        if (organizationRequest.getAddress() != null) {
            organization.setAddress(organizationRequest.getAddress());
        }
        if (organizationRequest.getItManagerId() != null) {
            User itManager = userRepository.findById(organizationRequest.getItManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + organizationRequest.getItManagerId()));
            organization.setItManager(itManager);
        }

        // Update the Sites
        if (organizationRequest.getSiteIds() != null && !organizationRequest.getSiteIds().isEmpty()) {
            List<Site> sites = siteRepository.findAllById(organizationRequest.getSiteIds());
            organization.setSites(sites);
        }

        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}
