package com.codhuman.pedra_hard_scan_quarkus.service;

import com.codhuman.pedra_hard_scan_quarkus.dao.HardwareInfoDao;
import com.codhuman.pedra_hard_scan_quarkus.model.HardwareInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HardwareInfoScanService {
    
    private final HardwareInfoDao hardwareInfoDao;

    public HardwareInfoScanService(HardwareInfoDao hardwareInfoDao) {
        this.hardwareInfoDao = hardwareInfoDao;
    }

    // public HardwareInfoDao getHardwareInfoDao() {
    public String getHardwareInfo() {
        HardwareInfo hardwareInfo = hardwareInfoDao.getHardwareInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(hardwareInfo);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return "";
        }
    }

    

}
