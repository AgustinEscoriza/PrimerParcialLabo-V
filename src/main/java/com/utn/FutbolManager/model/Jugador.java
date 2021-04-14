package com.utn.FutbolManager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Jugador extends Persona{

    private Float peso;
    private Float altura;
    private Integer goles;
    private Integer minutosJugados;
    private Date fechaNacimiento;

    @OneToOne( fetch = FetchType.EAGER) // asumo que cada jugador tiene una sola currency, ya que seria su valor en el mercado
    private Currency currency;

    @Override
    public TypePersona typePersona(){
        return TypePersona.JUGADOR;
    }
}
