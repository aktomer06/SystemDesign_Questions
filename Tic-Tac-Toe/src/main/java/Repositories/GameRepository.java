package Repositories;

import Models.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    static GameRepository gameRepository = new GameRepository();
    List<Game> games = new ArrayList<>();
   public static GameRepository getInstance() {
       return gameRepository;
   }
    private GameRepository() {

    }
    public Game save(Game game) {
        this.games.add(game);
        return game;
    }
    public Game findById(Integer gameId) {
        for (Game game : games) {
            if(game.getGameId() == gameId) {
                return game;
            }
        }
        return null;
    }
}
