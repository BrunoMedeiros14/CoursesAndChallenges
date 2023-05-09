package com.medeiros.apigamelist.repositories;

import com.medeiros.apigamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
