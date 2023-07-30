package com.codhuman.pedra_hard_scan_quarkus.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProcessorInfoDTOSerializer extends JsonSerializer<ProcessorInfoDTO> {
    @Override
    public void serialize(ProcessorInfoDTO processorInfoDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(processorInfoDTO.getProcessorName());
    }
}

