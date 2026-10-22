package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Employe;

public interface IEmployeService {

    Employe create(Employe employe);

    Employe findById(Long id);

    List<Employe> findAll();

    Employe update(Long id, Employe employe);

    void deleteById(Long id);
}
