package com.medeiros.apigamelist.repositories;

import com.medeiros.apigamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
