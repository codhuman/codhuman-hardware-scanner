package com.codhuman.pedra_hard_scan_quarkus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Storage {
    
    @Id
    private String id;
    private String manufacturer;
    private String model;
    private String type;
    private int size;
    
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    // Getters and setters...
}
