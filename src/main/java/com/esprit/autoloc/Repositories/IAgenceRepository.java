package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgenceRepository extends JpaRepository<Agence,Long> {
}
