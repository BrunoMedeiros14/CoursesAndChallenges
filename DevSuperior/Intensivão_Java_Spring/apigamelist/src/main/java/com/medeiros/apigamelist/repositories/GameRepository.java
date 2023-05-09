package com.medeiros.apigamelist.repositories;

import com.medeiros.apigamelist.entities.Game;
import com.medeiros.apigamelist.projection.GameMinProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Long> {
  @Query(
    nativeQuery = true, // Define que vai usar query nativo em vez do Jpa.
    value = """
		SELECT
    tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
		"""
  )
  List<GameMinProjection> searchByList(Long listId);
}
