/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aqualife.Aqualife.controller;

import com.Aqualife.Aqualife.model.param;
import com.Aqualife.Aqualife.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
}
