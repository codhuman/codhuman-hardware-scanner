package com.codhuman.pedra_hard_scan_quarkus.controller;

import com.codhuman.pedra_hard_scan_quarkus.service.HardwareInfoScanService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hardwareinfoscan")
public class HardwareInfoScanController {

    private final HardwareInfoScanService hardwareInfoScanService;

    @Inject
    public HardwareInfoScanController(HardwareInfoScanService hardwareInfoScanService) {
        this.hardwareInfoScanService = hardwareInfoScanService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHardwareInfo() {
        return hardwareInfoScanService.getHardwareInfo();
    }

    

}
