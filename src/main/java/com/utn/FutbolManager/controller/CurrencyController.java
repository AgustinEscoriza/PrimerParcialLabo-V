package com.utn.FutbolManager.controller;

import com.utn.FutbolManager.model.Currency;
import com.utn.FutbolManager.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping
    public void addCurrency(@RequestBody Currency currency){ currencyService.addCurrency(currency);}

    @GetMapping
    public List<Currency> getAll(){ return currencyService.getAll();}

    @GetMapping("/{currencyId}")
    public Currency getById(@PathVariable String Id){ return currencyService.getById(Id);}

    @DeleteMapping("/{currencyId}")
    public void deleteById(@PathVariable String Id){  currencyService.deleteById(Id);}
}
