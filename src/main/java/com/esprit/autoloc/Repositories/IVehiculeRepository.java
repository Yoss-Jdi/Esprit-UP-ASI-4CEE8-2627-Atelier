package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}
