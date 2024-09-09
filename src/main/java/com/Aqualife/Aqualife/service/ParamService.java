/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Aqualife.Aqualife.service;

import com.Aqualife.Aqualife.model.param;
import java.util.List;

/**
 *
 * @author STEVE KENNETH
 */
public interface ParamService {
    
    
    param getParamById(String name);
    
    
    public param SaveParam(param Param);
    
    public List<param> getAllParams();
    
    param updateParam(param Param, String name);

    void deleteParam(String name);
    
    
}
