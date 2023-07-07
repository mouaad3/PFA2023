package com.PFA.emsi.service.standard;

import com.PFA.emsi.Request.StandardRequest;
import com.PFA.emsi.model.Standard;

import java.util.List;

public interface StandardService {

    public List<Standard> getAllStandards();

    public Standard getStandardById(Long id);


    public Standard createStandard(StandardRequest standardRequest);

    public Standard updateStandard(Long id, Standard updatedStandard);

    public void deleteStandard(Long id);
}
