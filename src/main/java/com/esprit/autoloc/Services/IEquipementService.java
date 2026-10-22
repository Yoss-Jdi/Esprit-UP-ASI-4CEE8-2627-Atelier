package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Equipement;

public interface IEquipementService {

    Equipement create(Equipement equipement);

    Equipement findById(Long id);

    List<Equipement> findAll();

    Equipement update(Long id, Equipement equipement);

    void deleteById(Long id);
}
