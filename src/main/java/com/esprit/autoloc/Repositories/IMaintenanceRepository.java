package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}
