package com.utn.FutbolManager.controller;

import com.utn.FutbolManager.api.ApiCallService;
import com.utn.FutbolManager.api.FutbolistaResponse;
import com.utn.FutbolManager.model.dto.ListadoDTO;
import com.utn.FutbolManager.service.CumpleanitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CumpleanitoController {

    @Autowired
    private ApiCallService apiCallService;
    @Autowired
    private CumpleanitoService cumpleanitoService;


    //@GetMapping("{idCumpleanito}")
    //public ResponseEntity<List<ListadoDTO>> getListadoInvitados(@PathVariable Integer idCumpleanito,
    //                                                            @RequestParam(defaultValue = "0") Integer page,
    //                                                            @RequestParam(defaultValue = "5") Integer size,
    //                                                            @RequestParam(defaultValue = "id") String sortField1,
    //                                                            @RequestParam(defaultValue = "serialNumber") String sortField2) throws IOException, InterruptedException{
    //    ArrayList<Sort.Order> orders = new ArrayList<>();
    //    orders.add(new Sort.Order(Sort.Direction.ASC, sortField1));
    //    orders.add(new Sort.Order(Sort.Direction.ASC, sortField2));
//
    //    Page<List<ListadoDTO>> invitados = cumpleanitoService.getInvitadosPorCumpleanito(idCumpleanito,page,size,orders);
//
    //    return ResponseEntity.status(HttpStatus.OK)
    //            .header("X-Total-Elements", Long.toString(invitados.getTotalElements()))
    //            .header("X-Total-Pages", Long.toString(invitados.getTotalPages()))
    //            .header("X-Actual-Page",Integer.toString(page))
    //            .header("X-First-Sort-By", sortField1)
    //            .header("X-Second-Sort-By", sortField2)
    //            .body(invitados.getContent());
    //}
}
