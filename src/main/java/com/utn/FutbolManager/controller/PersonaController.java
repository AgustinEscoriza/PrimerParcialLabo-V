package com.utn.FutbolManager.controller;

import com.utn.FutbolManager.model.Persona;
import com.utn.FutbolManager.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public void addPersona(@RequestBody Persona persona){ personaService.addPersona(persona);}

    @GetMapping
    public List<Persona> getAll(){ return personaService.getAll();}

    @GetMapping("/{personaId}")
    public Persona getById(@PathVariable String personaId){ return personaService.getById(personaId);}

    @DeleteMapping("/{personaId}")
    public void deleteById(@PathVariable String Id){ personaService.deleteById(Id);}

    @PutMapping("/person/{id}/jugadores/{idJugador}")
    public void addJugadorToRepresentante(@PathVariable String id, @PathVariable String IdJugador){
        personaService.addJugadorToRepresentante(id, IdJugador);
    }
}
