package com.utn.FutbolManager.service;

import com.utn.FutbolManager.model.Currency;
import com.utn.FutbolManager.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public void addCurrency(Currency currency){
        currencyRepository.save(currency);
    }

    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }
    public Currency getById(String Id){
        return currencyRepository.findById(Id).orElseThrow( ()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
    public void deleteById(String Id){
        if(!currencyRepository.existsById(Id)){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        currencyRepository.deleteById(Id);
    }

}
