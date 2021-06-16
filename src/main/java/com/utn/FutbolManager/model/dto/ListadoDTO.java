package com.utn.FutbolManager.model.dto;

import com.utn.FutbolManager.model.Jugador;
import com.utn.FutbolManager.model.Persona;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ListadoDTO {

    private String nombre;
    private String currency;
    private Float amount;

    //public static ListadoDTO from (Jugador j){
    //    return ListadoDTO.builder()
    //            .nombre(j.getName() + j.getLastName())
    //            .currency(j.getCurrency().getNombre())
    //            .build();
    //}
//
    //public static List<ListadoDTO> from (List<Jugador> personaList){
    //    List<ListadoDTO> listDto = new ArrayList<>();
//
    //    for(Jugador j : personaList){
    //        listDto.add(ListadoDTO.from(j));
    //    }
    //    return listDto;
    //}
}
