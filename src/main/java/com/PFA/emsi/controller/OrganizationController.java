package com.PFA.emsi.controller;

import com.PFA.emsi.model.Organization;
import com.PFA.emsi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public Organization getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable Long id, @RequestBody Organization organization) {
        return organizationService.updateOrganization(id, organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }
}
