package com.utn.FutbolManager.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public enum Currency {

    DOLAR(1,"USD",150.0f),
    EURO(2,"EU",170.0f);

    private Integer id;
    private String nombre;
    private Float cambio;

    Currency(Integer id, String nombre, Float cambioAPesos) {
        this.id = id;
        this.nombre = nombre;
        this.cambio = cambioAPesos;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getCambio() {
        return cambio;
    }
}
