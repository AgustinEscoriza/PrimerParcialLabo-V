package com.utn.FutbolManager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Representante extends Persona{

    private Float pesoBoveda;
    private Float montoTotal;

    @OneToMany( fetch = FetchType.EAGER)
    @JoinColumn( name = "jugador_id")
    private List<Jugador> jugadores;

    @Override
    public TypePersona typePersona(){
        return TypePersona.REPRESNTANTE;
    }
}
