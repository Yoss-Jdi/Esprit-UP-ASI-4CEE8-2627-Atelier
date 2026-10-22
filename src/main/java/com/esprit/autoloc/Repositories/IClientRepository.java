package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Integer> {
}
