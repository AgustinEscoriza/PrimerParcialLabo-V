package com.utn.FutbolManager.repository;

import com.utn.FutbolManager.model.Cumpleanito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CumpleanitoRepository extends JpaRepository<Cumpleanito, String> {
    Cumpleanito findById(Integer id);
}
