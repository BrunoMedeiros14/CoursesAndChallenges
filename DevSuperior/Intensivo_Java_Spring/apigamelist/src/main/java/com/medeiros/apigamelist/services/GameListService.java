package com.medeiros.apigamelist.services;

import com.medeiros.apigamelist.dto.GameListDTO;
import com.medeiros.apigamelist.entities.GameList;
import com.medeiros.apigamelist.projection.GameMinProjection;
import com.medeiros.apigamelist.repositories.GameListRepository;
import com.medeiros.apigamelist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Registrando essa classe no sistema do spring, semente verde ao lado.
public class GameListService {

  @Autowired // Injeta o repository ao service por estarem em camadas diferentes.
  private GameListRepository gameListRepository;

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    List<GameListDTO> dto = result.stream().map(GameListDTO::new).toList();

    return dto;
  }

  @Transactional
  public void moveGameInList(
    Long listId,
    int sourceIndex,
    int destinationIndex
  ) {
    List<GameMinProjection> list = gameRepository.searchByList(listId);
    GameMinProjection obj = list.remove(sourceIndex);

    list.add(destinationIndex, obj);

    int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

    for (int i = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(
        listId,
        list.get(i).getId(),
        i
      );
    }
  }
}
