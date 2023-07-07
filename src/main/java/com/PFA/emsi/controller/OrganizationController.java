package com.PFA.emsi.controller;

import com.PFA.emsi.Request.OrganizationRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Organization;
import com.PFA.emsi.model.User;
import com.PFA.emsi.service.Organization.OrganizationService;
import com.PFA.emsi.service.Organization.OrganizationServiceImpl;
import com.PFA.emsi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationService organizationService;
    private final UserService userService;

    public OrganizationController(OrganizationService organizationService, UserService userService) {
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @GetMapping("/getAllOrganisations")
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/getOrganizationById/{id}")
    public Organization getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping("/addOrganisation")
    public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationRequest organizationRequest) {
        Organization organization = organizationService.createOrganization(organizationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(organization);
    }

    @PatchMapping("/updateOrganization/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long id, @RequestBody OrganizationRequest organizationRequest) {
        Organization organization = organizationService.updateOrganization(id, organizationRequest);
        return ResponseEntity.ok(organization);
    }


    @DeleteMapping("/deleteOrganizationById/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }
}
