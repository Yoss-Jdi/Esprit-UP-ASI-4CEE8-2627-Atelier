package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Agence;

public interface IAgenceService {

    Agence create(Agence agence);

    Agence findById(Long id);

    List<Agence> findAll();

    Agence update(Long id, Agence agence);

    void deleteById(Long id);
}
