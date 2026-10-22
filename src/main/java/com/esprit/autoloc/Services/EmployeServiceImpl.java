package com.esprit.autoloc.Services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.esprit.autoloc.Entities.Employe;
import com.esprit.autoloc.exception.ResourceNotFoundException;
import com.esprit.autoloc.Repositories.IEmployeRepository;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;

    @Override
    public Employe create(Employe employe) {
        if (employe.getIdEmploye() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau employe ne doit pas avoir d'identifiant");
        }
        valider(employe);
        return employeRepository.save(employe);
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe", id));
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe update(Long id, Employe employe) {
        valider(employe);
        Employe existant = findById(id);
        existant.setNom(employe.getNom());
        existant.setPrenom(employe.getPrenom());
        existant.setRole(employe.getRole());
        return employeRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employe", id);
        }
        employeRepository.deleteById(id);
    }

    private void valider(Employe employe) {
        if (employe.getNom() == null || employe.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom de l'employé obligatoire");
        }

        if (employe.getPrenom() == null || employe.getPrenom().isBlank()) {
            throw new IllegalArgumentException("Le prénom de l'employé obligatoire");
        }

        if (employe.getRole() == null) {
            throw new IllegalArgumentException("Le rôle de l'employé est obligatoire");
        }
    }
}
