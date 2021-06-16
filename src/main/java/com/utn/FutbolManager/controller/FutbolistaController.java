package com.utn.FutbolManager.controller;

import com.utn.FutbolManager.api.ApiCallService;
import com.utn.FutbolManager.api.FutbolistaResponse;
import com.utn.FutbolManager.service.CumpleanitoService;
import com.utn.FutbolManager.service.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Futbolista")
public class FutbolistaController {
    private final ApiCallService apiCallService;

    private final FutbolistaService futbolistaService;

    @Autowired
    public FutbolistaController(ApiCallService apiCallService, FutbolistaService futbolistaService) {
        this.apiCallService = apiCallService;
        this.futbolistaService = futbolistaService;
    }

    @GetMapping("/promesas") //el size me trae las 2 promesas en la primer pagina
    public ResponseEntity<List<FutbolistaResponse>> getPromesas(@RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "2") Integer size) throws IOException, InterruptedException {

        List<FutbolistaResponse> futbolistasResponse = apiCallService.getFutbolistasResponse();

        Page<FutbolistaResponse> promesas = futbolistaService.getJovenesAltos(page,size,futbolistasResponse); //no se me ocurrio otro nombre

        return ResponseEntity.ok()
                .header("X-Total-Pages", Long.toString(promesas.getTotalPages()))
                .header("X-Total-Elements", Long.toString(promesas.getTotalElements()))
                .body(promesas.getContent());
    }
}
