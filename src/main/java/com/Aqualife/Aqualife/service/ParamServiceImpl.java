
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
    
    
    
    @Override
    public param SaveParam(param Param) {
        return paramrepo.save(Param);
    }
    
    @Override
    public List<param> getAllParams(){
        return paramrepo.findAll();

    }
    
    @Override
    public param updateParam(param Param, String name) {
        return paramrepo.findById(name).map(pm -> {
            pm.setName(Param.getName());
            pm.setWater_temp(Param.getWater_temp());
            pm.setPh_level(Param.getPh_level());
            pm.setTank_size(Param.getTank_size());
            pm.setBehaviour(Param.getBehaviour());
            pm.setDiet(Param.getDiet());

            return paramrepo.save(pm);
        }).orElseThrow(() -> new ParamNotFound("System Error"));
    }
    
    @Override
    public void deleteParam(String name) {
        if (!paramrepo.existsById(name)){
            throw new ParamNotFound("System Error");
        }
        
        paramrepo.deleteById(name);
    }
    
}
