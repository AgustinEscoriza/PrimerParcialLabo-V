package com.utn.FutbolManager.repository;

import com.utn.FutbolManager.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}
