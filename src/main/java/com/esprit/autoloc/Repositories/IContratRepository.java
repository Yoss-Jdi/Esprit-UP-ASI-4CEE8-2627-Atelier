package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}
