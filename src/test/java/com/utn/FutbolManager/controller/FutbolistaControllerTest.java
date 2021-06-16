package com.utn.FutbolManager.controller;

import com.utn.FutbolManager.api.ApiCallService;
import com.utn.FutbolManager.api.FutbolistaResponse;
import com.utn.FutbolManager.service.FutbolistaService;
import com.utn.FutbolManager.service.FutbolistaServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FutbolistaControllerTest {

    private FutbolistaService futbolistaService;
    private ApiCallService apiCallService;

    private FutbolistaController futbolistaController;

    private static List<FutbolistaResponse> EMPTY_LIST = Collections.emptyList();
    private static List<FutbolistaResponse> FUTBOL_LIST = List.of(FutbolistaResponse.builder().lastname("Colombatto").firstName("Santiago").age(19).height(190).player_id(2103).build(),
            FutbolistaResponse.builder().lastname("Juan").firstName("Perez").age(19).height(190).player_id(2323).build());

    @BeforeEach
    public void setUp(){
        futbolistaService = mock(FutbolistaService.class);
        apiCallService = mock(ApiCallService.class);
        futbolistaController = new FutbolistaController(apiCallService,futbolistaService);
    }

    @Test
    public void testGetPromesasOK() throws IOException, InterruptedException {
        //Given
        Page<FutbolistaResponse> mockedPage = mock(Page.class);
        when(mockedPage.getTotalElements()).thenReturn(100L);
        when(mockedPage.getTotalPages()).thenReturn(10);
        when(mockedPage.getContent()).thenReturn(FUTBOL_LIST);
        when(futbolistaService.getJovenesAltos(0,2,FUTBOL_LIST)).thenReturn(mockedPage);
        //Then
        ResponseEntity<List<FutbolistaResponse>> response = futbolistaController.getPromesas(0,2);
        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(100L, Long.parseLong(response.getHeaders().get("X-Total-Count").get(0)) );
        assertEquals(10, Integer.parseInt(response.getHeaders().get("X-Total-Pages").get(0)) );
        assertEquals(FUTBOL_LIST, response.getBody());
    }
    @Test
    public void testGetPromesas204() throws IOException, InterruptedException {
        //Given
        Page<FutbolistaResponse> mockedPage = mock(Page.class);
        when(mockedPage.getContent()).thenReturn(EMPTY_LIST);
        when(futbolistaService.getJovenesAltos(1,2,FUTBOL_LIST)).thenReturn(mockedPage);

        //Then
        ResponseEntity<List<FutbolistaResponse>> response = futbolistaController.getPromesas(1,2);

        //Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }
}
