package com.PFA.emsi.controller;


import com.PFA.emsi.Request.SiteRequest;
import com.PFA.emsi.Request.SiteUpdateRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Organization;
import com.PFA.emsi.model.Process;
import com.PFA.emsi.model.Site;
import com.PFA.emsi.service.Organization.OrganizationService;
import com.PFA.emsi.service.process.ProcessServiceImpl;
import com.PFA.emsi.service.Site.SiteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/site")
public class SiteController {

    private final SiteServiceImpl siteService;
    private final OrganizationService organizationService;
    private final ProcessServiceImpl processService;

    public SiteController(SiteServiceImpl siteService, OrganizationService organizationService, ProcessServiceImpl processService) {
        this.siteService = siteService;
        this.organizationService = organizationService;
        this.processService = processService;
    }
    @GetMapping("/getAllSites")
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }

    @GetMapping("/getSiteById/{id}")
    public Site getSiteById(@PathVariable Long id) {
        return siteService.getSiteById(id);
    }

    @PostMapping("/addSite")
    public ResponseEntity<Site> createSite(@RequestBody SiteRequest siteRequest) {
        Organization organization = organizationService.getOrganizationById(siteRequest.getOrganizationId());
        if (organization == null) {
            throw new ResourceNotFoundException("Organization not found with ID: " + siteRequest.getOrganizationId());
        }

        Site site = new Site();
        site.setName(siteRequest.getName());
        site.setAddress(siteRequest.getAddress());
        site.setDescription(siteRequest.getDescription());
        site.setOrganization(organization);
        if (siteRequest.getProcessIds() != null && !siteRequest.getProcessIds().isEmpty()) {
            List<Process> processes = new ArrayList<>();
            for (Long processId : siteRequest.getProcessIds()) {
                Process process = processService.getProcessById(processId);
                if (process != null) {
                    processes.add(process);
                }
            }
            site.setProcesses(processes);
        }

        Site savedSite = siteService.createSite(site);
        return ResponseEntity.ok(savedSite);
    }


    @PatchMapping("/updateSite/{id}")
    public ResponseEntity<Site> updateSite(@PathVariable Long id, @RequestBody SiteRequest siteRequest) {
        Site updatedSite = siteService.updateSite(id, siteRequest);
        return ResponseEntity.ok(updatedSite);
    }


    @DeleteMapping("/deleteSite/{id}")
    public void deleteSite(@PathVariable Long id) {
        siteService.deleteSite(id);
    }
}
