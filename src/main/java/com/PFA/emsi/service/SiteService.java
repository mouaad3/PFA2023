package com.PFA.emsi.service;

import com.PFA.emsi.model.Site;
import com.PFA.emsi.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    private final SiteRepository siteRepository;

    @Autowired
    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
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

    public Site updateSite(Long id, Site updatedSite) {
        Site site = getSiteById(id);
        if (site != null) {
            site.setName(updatedSite.getName());
            site.setAddress(updatedSite.getAddress());
            site.setDescription(updatedSite.getDescription());
            site.setOrganization(updatedSite.getOrganization());
            site.setProcesses(updatedSite.getProcesses());
            return siteRepository.save(site);
        }
        return null;
    }

    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }
}
