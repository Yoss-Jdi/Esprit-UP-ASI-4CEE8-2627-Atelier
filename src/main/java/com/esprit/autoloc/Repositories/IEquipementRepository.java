package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}
