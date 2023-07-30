package com.codhuman.pedra_hard_scan_quarkus.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

// Classe DTO para representar os dados do processador
@JsonSerialize(using = ProcessorInfoDTOSerializer.class)
public class ProcessorInfoDTO {
    private String processorName;

    // Construtor, getters e setters

    public ProcessorInfoDTO(String processorName) {
        this.processorName = processorName;
    }

    public String getProcessorName() {
        return processorName;
    }
    // ...
}
