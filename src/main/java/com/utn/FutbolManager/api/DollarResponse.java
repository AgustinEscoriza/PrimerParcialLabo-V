package com.utn.FutbolManager.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DollarResponse {

    @SerializedName("nombre")
    private String nombre;
    @SerializedName("compra")
    private Float compra;
    @SerializedName("venta")
    private Float venta;
    @SerializedName("agencia")
    private String agencia;
    @SerializedName("observaciones")
    private String observaciones;
    @SerializedName("geolocalizacion")
    private Map< String, String> geolocalizacion;
    @SerializedName("latitud")
    private String latitud;
    @SerializedName("longitud")
    private String longitud;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("decimales")
    private Integer decimales;
}
