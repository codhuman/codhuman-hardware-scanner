package com.codhuman.pedra_hard_scan_quarkus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GPU {
    
    @Id
    private String id;
    private String manufacturer;
    private String model;
    private int memorySize;
    
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
    public int getMemorySize() {
        return memorySize;
    }
    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    // Getters and setters...
}
