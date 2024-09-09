
package com.Aqualife.Aqualife.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Entity
@Table(name="tbl_param")
public class param {
    
    
    @Column(name = "id")
    private int id;
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "water_temp")
    private String water_temp;
    @Column(name = "ph_level")
    private String ph_level;
    @Column(name = "tank_size")
    private String tank_size;
    @Column(name = "behaviour")
    private String behaviour;
    @Column(name = "diet")
    private String diet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWater_temp() {
        return water_temp;
    }

    public void setWater_temp(String water_temp) {
        this.water_temp = water_temp;
    }

    public String getPh_level() {
        return ph_level;
    }

    public void setPh_level(String ph_level) {
        this.ph_level = ph_level;
    }

    public String getTank_size() {
        return tank_size;
    }

    public void setTank_size(String tank_size) {
        this.tank_size = tank_size;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    
    
}
