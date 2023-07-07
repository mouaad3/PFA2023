package com.PFA.emsi.service.Site;

import com.PFA.emsi.Request.SiteRequest;
import com.PFA.emsi.model.Site;

import java.util.List;

public interface SiteService {


    public List<Site> getAllSites();

    public Site getSiteById(Long id);

    public Site createSite(Site site);

    public Site updateSite(Long id, SiteRequest siteRequest);

    public void deleteSite(Long id);
}
