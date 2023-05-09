package com.medeiros.apigamelist.controllers;

import com.medeiros.apigamelist.dto.GameMinDTO;
import com.medeiros.apigamelist.services.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired // controller injeta o serviçe que injeta o repository
  GameService gameService;

  @GetMapping
  public List<GameMinDTO> findAll() {
    List<GameMinDTO> result = gameService.findAll();
    return result;
  }
}
