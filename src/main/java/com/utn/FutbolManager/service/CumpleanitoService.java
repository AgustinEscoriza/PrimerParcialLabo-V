package com.utn.FutbolManager.service;

import com.utn.FutbolManager.api.ApiCallService;
import com.utn.FutbolManager.model.Cumpleanito;
import com.utn.FutbolManager.model.Jugador;
import com.utn.FutbolManager.model.Persona;
import com.utn.FutbolManager.model.dto.ListadoDTO;
import com.utn.FutbolManager.repository.CumpleanitoRepository;
import com.utn.FutbolManager.repository.PersonaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Page<ListadoDTO> getInvitadosPorCumpleanito(Integer idCumpleanito, Integer page, Integer size, ArrayList<Sort.Order> orders) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(orders));

        Cumpleanito c = cumpleanitoRepository.findById(idCumpleanito);

        Set<Persona> invitados = c.getInvitados();
        List<ListadoDTO> listadoDTO = new ArrayList<>();
        for(Persona p: invitados){ //hasta aca lle
            apiCallService.getDolarResponse();
            listadoDTO.add(ListadoDTO.from((Jugador) p));
        }
        return listadoDTO;
    }
}
