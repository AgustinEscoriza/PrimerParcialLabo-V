package com.utn.FutbolManager.service;

import com.utn.FutbolManager.api.FutbolistaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FutbolistaService {

    public Page<FutbolistaResponse> getJovenesAltos(Integer page, Integer size,List<FutbolistaResponse> futbolistaList){
        Pageable pageable = PageRequest.of(page,size);
        Integer maxAge = 20;
        Integer minHeight = 180;
        List<FutbolistaResponse> promesaList = new ArrayList<FutbolistaResponse>();

        for(FutbolistaResponse f: futbolistaList){
            if(f.getHeight() >= minHeight){
                if(f.getAge() <= maxAge){
                    promesaList.add(f);
                }
            }
        }
        Page<FutbolistaResponse> futbolistaResponse = new PageImpl<>(promesaList,pageable,promesaList.size());
        return futbolistaResponse;
    }
}
