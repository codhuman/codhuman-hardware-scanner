package com.codhuman.pedra_hard_scan_quarkus.dto;

import com.codhuman.pedra_hard_scan_quarkus.model.CPU;
import com.codhuman.pedra_hard_scan_quarkus.model.GPU;
import com.codhuman.pedra_hard_scan_quarkus.model.RAM;
import com.codhuman.pedra_hard_scan_quarkus.model.Storage;

public class HardwareInfoDto {

    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    
    public CPU getCpu() {
        return cpu;
    }
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public GPU getGpu() {
        return gpu;
    }
    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }
    public RAM getRam() {
        return ram;
    }
    public void setRam(RAM ram) {
        this.ram = ram;
    }
    public Storage getStorage() {
        return storage;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }


}
