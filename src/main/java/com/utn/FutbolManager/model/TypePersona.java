package com.utn.FutbolManager.model;



public enum TypePersona {
    JUGADOR("Jugador"),
    REPRESNTANTE("Manager");

    private String descripcion;

    TypePersona(String descripcion){ this.descripcion = descripcion;}

    public static TypePersona find( final String valor){
        for(TypePersona p: values()){
            if(p.toString().equalsIgnoreCase(valor)){
                return p;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypePersona: %s", valor));
    }
    public String getDescripcion() {
        return descripcion;
    }
}
