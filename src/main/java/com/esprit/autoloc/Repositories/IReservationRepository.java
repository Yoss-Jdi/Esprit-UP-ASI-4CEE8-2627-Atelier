package com.esprit.autoloc.Repositories;

import com.esprit.autoloc.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
}
