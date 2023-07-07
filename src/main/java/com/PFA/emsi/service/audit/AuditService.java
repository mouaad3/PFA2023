package com.PFA.emsi.service.audit;

import com.PFA.emsi.Request.AuditRequest;
import com.PFA.emsi.model.Audit;

import java.util.List;

public interface AuditService {

    public List<Audit> getAllAudits();

    public Audit getAuditById(Long id);

    public Audit createAudit(AuditRequest auditRequest);

    public Audit updateAudit(Long id, AuditRequest auditRequest);

    public boolean deleteAudit(Long id);
}
