package com.utn.FutbolManager.service;

import com.utn.FutbolManager.api.ApiCallService;
import com.utn.FutbolManager.api.DollarResponse;
import com.utn.FutbolManager.api.EuroResponse;
import com.utn.FutbolManager.model.Cumpleanito;
import com.utn.FutbolManager.model.Jugador;
import com.utn.FutbolManager.model.Persona;
import com.utn.FutbolManager.model.dto.ListadoDTO;
import com.utn.FutbolManager.repository.CumpleanitoRepository;
import com.utn.FutbolManager.repository.PersonaRepository;
import lombok.SneakyThrows;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CumpleanitoService {



    private static final String PERSONA_PATH = "persona";
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ApiCallService apiCallService;
    @Autowired
    private CumpleanitoRepository cumpleanitoRepository;

    //@SneakyThrows
    //public Page<ListadoDTO> getInvitadosPorCumpleanito(Integer idCumpleanito, Integer page, Integer size, ArrayList<Sort.Order> orders) throws IOException, InterruptedException {
    //    Pageable pageable = PageRequest.of(page,size,Sort.by(orders));
//
    //    Cumpleanito c = cumpleanitoRepository.findById(idCumpleanito);
//
    //    Set<Persona> invitados = c.getInvitados();
    //    Set<Jugador> invitadosJugadores = new HashSet<>();
//
    //    for( Persona p: invitados){
    //        if(p.getClass().getSimpleName() == "Jugador"){
    //            invitadosJugadores.add((Jugador) p);
    //        }
    //    }
    //
    //    List<ListadoDTO> listadoDTO = new ArrayList<>();
    //    ListadoDTO dto = new ListadoDTO();
//
    //    for(Jugador j: invitadosJugadores) {
    //        if (j.getCurrency().getNombre() == "USD") {
    //            DollarResponse dollar = apiCallService.getDolarResponse();
    //            dto.setAmount(j.getValorMercado() / dollar.getVenta());
    //            dto.setNombre(j.getName());
    //            dto.setCurrency(j.getCurrency().getNombre());
    //            listadoDTO.add(dto);
    //        }
    //        if (j.getCurrency().getNombre() == "EU") {
    //            EuroResponse euro = apiCallService.getEuroResponse();
    //            dto.setAmount(j.getValorMercado() / euro.getVenta());
    //            dto.setNombre(j.getName());
    //            dto.setCurrency(j.getCurrency().getNombre());
    //            listadoDTO.add(dto);
    //        }
    //    }
    //    Page<List<ListadoDTO>> listPage = Page.empty().map();;
    //    return listadoDTO;
    //}
}
