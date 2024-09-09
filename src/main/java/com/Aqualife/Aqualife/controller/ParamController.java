
package com.Aqualife.Aqualife.controller;

import com.Aqualife.Aqualife.model.param;
import com.Aqualife.Aqualife.service.ParamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survival")
@CrossOrigin("http://localhost:3000")
public class ParamController {
    @Autowired
    private ParamService paramservice;
    
    @GetMapping("/{name}")
    public param getParamById(@PathVariable String name){
        return paramservice.getParamById(name);
    }
    

    
    @PostMapping("/add")
    public String add(@RequestBody param Param){
        paramservice.SaveParam(Param);
        return "New Species added";
    }
    
     @GetMapping("/getAll")
    public List<param> getAllParams(){
        return paramservice.getAllParams();
    }
    
        @PutMapping("/update/{name}")
    public param updateParam(@RequestBody param Param, @PathVariable String name){
        return paramservice.updateParam(Param, name);

    }
    
        @DeleteMapping("/delete/{name}")
    public void deleteParam(@PathVariable String name){
        paramservice.deleteParam(name);
    }
    
}
