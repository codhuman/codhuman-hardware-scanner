package com.codhuman.pedra_hard_scan_quarkus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CPU {
    
    @Id
    private String id;
    private String manufacturer;
    private String model;
    private int coreCount;
    private float clockSpeed;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getCoreCount() {
        return coreCount;
    }
    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }
    public float getClockSpeed() {
        return clockSpeed;
    }
    public void setClockSpeed(float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    // Getters and setters...
}