package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Client;

public interface IClientService {

    Client create(Client client);

    Client findById(Long id);

    List<Client> findAll();

    Client update(Long id, Client client);

    void deleteById(Long id);
}
