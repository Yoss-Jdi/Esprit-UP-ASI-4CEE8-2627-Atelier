package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Maintenance;

public interface IMaintenanceService {

    Maintenance create(Maintenance maintenance);

    Maintenance findById(Long id);

    List<Maintenance> findAll();

    Maintenance update(Long id, Maintenance maintenance);

    void deleteById(Long id);
}
