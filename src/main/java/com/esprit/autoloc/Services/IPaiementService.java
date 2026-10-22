package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Paiement;

public interface IPaiementService {

    Paiement findById(Long id);

    List<Paiement> findAll();
}
