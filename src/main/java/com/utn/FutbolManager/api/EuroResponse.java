package com.utn.FutbolManager.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EuroResponse {

    private String nombre;
    private Float compra;
    private Float venta;
}
