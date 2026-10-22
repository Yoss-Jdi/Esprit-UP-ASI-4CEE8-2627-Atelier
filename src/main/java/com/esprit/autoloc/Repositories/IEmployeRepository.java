package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}
