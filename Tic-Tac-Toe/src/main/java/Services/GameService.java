package Services;

import Dtos.GameRequestDto;
import Dtos.PlayerDto;
import Constants.PlayerType;
import Models.Board;
import Models.Game;
import Models.Player;
import Models.PlayerFactory;
import Models.User;
import Repositories.GameRepository;
import Strategy.EasyStrategy;
import Strategy.GreedyStrategy;
import Strategy.MediumStrategy;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Player createHumanPlayer(PlayerDto playerDto) {
        return PlayerFactory.createHumanPlayer()
                .setUser(new User())
                .setSymbol(playerDto.getSymbol())
                .build();
    }
    private Player createComputerPlayer(PlayerDto playerDto) {
        switch(playerDto.getDifficultyLevel()) {
            case EASY -> {
                return PlayerFactory.createComputerPlayer()
                        .setSymbol(playerDto.getSymbol())
                        .setDifficultyLevel(new EasyStrategy())
                        .build();
            }
            case Medium -> {
                return PlayerFactory.createComputerPlayer()
                        .setSymbol(playerDto.getSymbol())
                        .setDifficultyLevel(new MediumStrategy())
                        .build();
            }
        }
        throw new InvalidParameterException("Difficulty level is not implemented");
    }
    public Game createGame(GameRequestDto gameRequestDto) {
        List<Player> playerList = new ArrayList<>();
        for(PlayerDto playerDto : gameRequestDto.getPlayerList()) {
            if(playerDto.getPlayerType() == PlayerType.COMPUTER) {
                playerList.add(createComputerPlayer(playerDto));
            }
            else if(playerDto.getPlayerType() == PlayerType.HUMAN) {
                playerList.add(createHumanPlayer(playerDto));
            }
            else {
                throw new InvalidParameterException("Player type is not valid");
            }
        }
        Game game =  Game.builder()
                .setGameId((int)Math.random()%100)
                .setBoard(new Board(gameRequestDto.getRows(), gameRequestDto.getCols()))
                .setPlayerList(playerList)
                .setWinningStrategy(new GreedyStrategy())
                .build();
        return GameRepository.getInstance().save(game);
    }
}
