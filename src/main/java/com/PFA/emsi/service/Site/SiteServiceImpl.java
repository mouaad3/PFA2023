package com.PFA.emsi.service.Site;

import com.PFA.emsi.Request.SiteRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Organization;
import com.PFA.emsi.model.Process;
import com.PFA.emsi.model.Site;
import com.PFA.emsi.repository.OrganizationRepository;
import com.PFA.emsi.repository.ProcessRepository;
import com.PFA.emsi.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final ProcessRepository processRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public SiteServiceImpl(SiteRepository siteRepository, ProcessRepository processRepository, OrganizationRepository organizationRepository) {
        this.siteRepository = siteRepository;
        this.processRepository = processRepository;
        this.organizationRepository = organizationRepository;
    }

    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public Site getSiteById(Long id) {
        return siteRepository.findById(id).orElse(null);
    }

    public Site createSite(Site site) {
        return siteRepository.save(site);
    }

    public Site updateSite(Long id, SiteRequest siteRequest) {
        Site site = siteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Site not found with ID: " + id));

        site.setName(siteRequest.getName());
        site.setAddress(siteRequest.getAddress());
        site.setDescription(siteRequest.getDescription());

        // Set other attributes as needed
        site.setOrganization(organizationRepository.findById(siteRequest.getOrganizationId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found with ID: " + siteRequest.getOrganizationId())));

        List<Process> processes = new ArrayList<>();
        System.err.println("processId is: "+siteRequest.getProcessIds());
        if (siteRequest.getProcessIds() != null) {
            for (Long processId : siteRequest.getProcessIds()) {
                Process process = processRepository.findById(processId)
                        .orElseThrow(() -> new ResourceNotFoundException("Process not found with ID: " + processId));
                processes.add(process);
            }
        }
        site.setProcesses(processes);

        return siteRepository.save(site);
    }



    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }
}
