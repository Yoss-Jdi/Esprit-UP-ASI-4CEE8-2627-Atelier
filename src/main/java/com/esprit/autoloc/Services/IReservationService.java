package com.esprit.autoloc.Services;

import java.util.List;
import com.esprit.autoloc.Entities.Reservation;

public interface IReservationService {

    Reservation create(Reservation reservation);

    Reservation findById(Long id);

    List<Reservation> findAll();

    Reservation update(Long id, Reservation reservation);

    void deleteById(Long id);
}
