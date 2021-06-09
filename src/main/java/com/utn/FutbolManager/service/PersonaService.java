package com.utn.FutbolManager.service;


import com.utn.FutbolManager.model.Currency;
import com.utn.FutbolManager.model.Jugador;
import com.utn.FutbolManager.model.Persona;
import com.utn.FutbolManager.model.Representante;
import com.utn.FutbolManager.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public void addPersona(Persona persona){
        personaRepository.save(persona);
    }

    public List<Persona> getAll(){
        return personaRepository.findAll();
    }
    public Persona getById(String Id){
        return personaRepository.findById(Id).orElseThrow( ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
    public void deleteById(String Id){
        if(!personaRepository.existsById(Id)){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    public void addJugadorToRepresentante(String Id, String IdJugador){
        Representante representante = (Representante)getById(Id);
        Jugador jugador = (Jugador)getById(IdJugador);
        representante.getJugadores().add(jugador);



    }
}
