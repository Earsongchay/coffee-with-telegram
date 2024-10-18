package org.example.coffeewithtelegram;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedRepo extends JpaRepository<Booked, Integer> {
}
