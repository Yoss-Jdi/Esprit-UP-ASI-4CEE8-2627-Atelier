package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
