package com.utn.FutbolManager.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Cumpleanito {
    @NotNull
    private LocalDate fecha;
    @OneToOne
    @JoinColumn(name = "persona_id")
    @NotNull
    private Persona cumpleaniero;
    @ManyToMany
    private Set<Persona> invitados;


}
