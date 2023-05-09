package com.medeiros.apigamelist.controllers;

import com.medeiros.apigamelist.dto.GameListDTO;
import com.medeiros.apigamelist.dto.GameMinDTO;
import com.medeiros.apigamelist.services.GameListService;
import com.medeiros.apigamelist.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

  @Autowired // controller injeta o serviçe que injeta o repository
  GameListService gameListService;

  @Autowired
  GameService gameService;

  @GetMapping
  public List<GameListDTO> findAll() {
    List<GameListDTO> result = gameListService.findAll();
    return result;
  }

  @GetMapping(value = "/{listId}/games")
  public List<GameMinDTO> findByList(@PathVariable Long listId) {
    List<GameMinDTO> result = gameService.findByList(listId);
    return result;
  }
}
