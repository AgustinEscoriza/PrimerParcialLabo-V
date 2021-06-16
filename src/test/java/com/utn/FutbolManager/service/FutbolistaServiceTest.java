package com.utn.FutbolManager.service;

import com.utn.FutbolManager.api.FutbolistaResponse;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FutbolistaServiceTest {

    private FutbolistaService futbolistaService;

    private static List<FutbolistaResponse> EMPTY_LIST = Collections.emptyList();
    private static List<FutbolistaResponse> FUTBOL_LIST = List.of(FutbolistaResponse.builder().lastname("Colombatto").firstName("Santiago").age(19).height(190).player_id(2103).build(),
            FutbolistaResponse.builder().lastname("Juan").firstName("Perez").age(19).height(190).player_id(2323).build());
    @BeforeEach
    public void setUp(){
        futbolistaService = new FutbolistaService();
    }

    public void getJovenesAltos(){
        Pageable pageable = PageRequest.of(1,2);

        Page<FutbolistaResponse> response = futbolistaService.getJovenesAltos(0,2,FUTBOL_LIST);

        assertEquals(19,response.getContent().get(0).getAge());
        assertEquals(2,response.getSize());
    }
}

