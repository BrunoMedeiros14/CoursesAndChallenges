package com.medeiros.apigamelist.services;

import com.medeiros.apigamelist.dto.GameMinDTO;
import com.medeiros.apigamelist.entities.Game;
import com.medeiros.apigamelist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Registrando essa classe no sistema do spring, semente verde ao lado.
public class GameService {

  @Autowired // Injeta o repository ao service por estarem em camadas diferentes.
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    List<GameMinDTO> dto = result
      .stream()
      .map(obj -> new GameMinDTO(obj))
      .toList();

    return dto;
  }
}
