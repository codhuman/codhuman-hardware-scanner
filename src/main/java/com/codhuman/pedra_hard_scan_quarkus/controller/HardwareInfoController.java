package com.codhuman.pedra_hard_scan_quarkus.controller;

import java.util.List;

import com.codhuman.pedra_hard_scan_quarkus.dto.ProcessorInfoDTO;
import com.codhuman.pedra_hard_scan_quarkus.model.HardwareInfo;
import com.codhuman.pedra_hard_scan_quarkus.service.HardwareInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hardwareinfo")
public class HardwareInfoController {

    private final HardwareInfoService hardwareInfoService;

    @Inject
    public HardwareInfoController(HardwareInfoService hardwareInfoService) {
        this.hardwareInfoService = hardwareInfoService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHardwareInfo() {
        return hardwareInfoService.getHardwareInfo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHardwareInfoById(@PathParam("id") int id) {
        HardwareInfo hardwareInfo = hardwareInfoService.getHardwareInfoById(id);

        if (hardwareInfo != null) {
            return Response.ok(hardwareInfo).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Registro não encontrado para o ID: " + id)
                    .build();
        }
    }

    @GET
    @Path("/cpu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCPUInfo() {
        String processorName = hardwareInfoService.getProcessorName();

        ProcessorInfoDTO processorInfoDTO = new ProcessorInfoDTO(processorName);
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(processorInfoDTO);
        } catch (JsonProcessingException e) {
            // Log da exceção
            e.printStackTrace();
            return Response.serverError().build();
        }

        return Response.ok(json).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHardwareInfo() {
        List<HardwareInfo> hardwareInfoList = hardwareInfoService.getAllHardwareInfo();

        if (hardwareInfoList != null && !hardwareInfoList.isEmpty()) {
            return Response.ok(hardwareInfoList).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhum registro encontrado na tabela HardwareInfo")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insertHardwareInfo(HardwareInfo hardwareInfo) {
        // hardwareInfo.setId("4");
        try {
            hardwareInfoService.insertHardwareInfo(hardwareInfo);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Tratar a exceção e retornar uma resposta de erro apropriada
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ocorreu um erro ao inserir as informações de hardware").build();
        }
    }
}
