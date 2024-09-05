
package com.Aqualife.Aqualife.service;

import com.Aqualife.Aqualife.Exception.ParamNotFound;
import com.Aqualife.Aqualife.Repo.ParamRepo;
import com.Aqualife.Aqualife.model.param;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamServiceImpl implements ParamService{
    @Autowired
    private ParamRepo paramrepo;

    @Override
    public param getParamById(String name) {
        return paramrepo.findById(name)
                .orElseThrow(() -> new ParamNotFound("Sorry, no information available :" +name));
    }
    
}
