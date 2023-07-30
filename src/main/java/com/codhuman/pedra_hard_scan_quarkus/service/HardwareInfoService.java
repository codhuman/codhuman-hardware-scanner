package com.codhuman.pedra_hard_scan_quarkus.service;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;

import com.codhuman.pedra_hard_scan_quarkus.dao.HardwareInfoDao;
import com.codhuman.pedra_hard_scan_quarkus.model.HardwareInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.enterprise.context.ApplicationScoped;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class HardwareInfoService {

    private final HardwareInfoDao hardwareInfoDao;

    public HardwareInfoService(HardwareInfoDao hardwareInfoDao) {
        this.hardwareInfoDao = hardwareInfoDao;
    }

    public HardwareInfo getHardwareInfoById(int id) {
        return hardwareInfoDao.getHardwareInfoById(id);
    }

    public List<HardwareInfo> getAllHardwareInfo() {
        return hardwareInfoDao.findAll();
    }

    public String getHardwareInfo() {
        HardwareInfo hardwareInfo = hardwareInfoDao.getHardwareInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(hardwareInfo);
        } catch (JsonProcessingException e) {
            // Trate a exceção ou retorne uma mensagem de erro apropriada
            e.printStackTrace();
            return "";
        }
    }

    public void insertHardwareInfo(HardwareInfo hardwareInfo) {
        hardwareInfoDao.save(hardwareInfo);
    }

    // public static String getProcessorModel() {
    // OperatingSystemMXBean operatingSystemMXBean =
    // ManagementFactory.getOperatingSystemMXBean();
    // if (operatingSystemMXBean instanceof
    // com.sun.management.OperatingSystemMXBean) {
    // com.sun.management.OperatingSystemMXBean sunOperatingSystemMXBean =
    // (com.sun.management.OperatingSystemMXBean) operatingSystemMXBean;
    // return sunOperatingSystemMXBean.getProcessor();
    // }
    // return null;
    // }
    public String printProcessorInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            com.sun.management.OperatingSystemMXBean sunOsBean = (com.sun.management.OperatingSystemMXBean) osBean;

            double processor = sunOsBean.getProcessCpuLoad();
            System.out.println("Processor: " + processor);
            return String.valueOf(processor);
        } else {
            System.out.println("OperatingSystemMXBean does not support processor information");
            return "OperatingSystemMXBean does not support processor information";
        }
    }

    public String getProcessorName() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            com.sun.management.OperatingSystemMXBean sunOsBean = (com.sun.management.OperatingSystemMXBean) osBean;

            String processorName = sunOsBean.getName();
            System.out.println("Processor Name: " + processorName);
            return processorName;
        } else {
            System.out.println("OperatingSystemMXBean does not support processor information");
            return "OperatingSystemMXBean does not support processor information";
        }
    }

}

// public String getHardwareInfo() {
// // Fetch hardware info from the database
// HardwareInfo hardwareInfo = hardwareInfoDao.getHardwareInfo();

// // Create a string representation of the hardware info
// StringBuilder sb = new StringBuilder();
// sb.append("CPU: ").append(hardwareInfo.getCpu()).append("\n");
// sb.append("GPU: ").append(hardwareInfo.getGpu()).append("\n");
// sb.append("RAM: ").append(hardwareInfo.getRam()).append("\n");
// sb.append("Storage: ").append(hardwareInfo.getStorage()).append("\n");

// return sb.toString();
// }