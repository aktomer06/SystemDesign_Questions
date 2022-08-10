package Models;

import Command.Symbol;
import Strategy.WinningStrategy;

import java.security.InvalidParameterException;
import java.util.*;

public class Game {

    private Integer gameId;
    private Models.Board board;
    private List<Models.Player> playerList;
    private WinningStrategy winningStrategy;

    public Models.Board getBoard() {
        return board;
    }

    public List<Models.Player> getPlayerList() {
        return playerList;
    }

    public Integer getGameId() {
        return gameId;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public static Builder builder() {

        return new Builder();
    }

    private Game() {

    }
    public void makeMove(Models.BoardCell boardCell, Integer playerId) {
        playerList.get(playerId).makeMove(board, boardCell);
    }

    public static class Builder {
        private Game game = new Game();
        public Builder setBoard(Models.Board board) {
            game.board = board;
            return this;
        }

        public Builder setGameId(Integer gameId) {
            game.gameId = gameId;
            return this;
        }
        public Builder addPlayer(Models.Player player) {
            game.playerList.add(player);
            return this;
        }

        public Builder setPlayerList(List<Models.Player> playerList) {
            game.playerList = playerList;
            return this;
        }
        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            game.winningStrategy = winningStrategy;
            return this;
        }
        private boolean validateGame() {
            if(game.playerList.size() > 2) {
                throw new InvalidParameterException("There should be two players in the Game");
            }
            if(game.board.getCells()[0].length > game.board.getCells().length) {
                throw new InvalidParameterException("Board dimension is not valid");
            }
            Set<Symbol> set = new HashSet<Symbol>();
            for(Models.Player player : game.playerList) {
                if(set.contains(player.symbol)) {
                    throw new InvalidParameterException("Chosen player are not valid");
                }
                set.add(player.symbol);
            }
            return true;
        }
        public Game build() {
            if(validateGame())
            {
                return game;
            }
            throw new InvalidParameterException("Game is not valid");
        }
    }
}
