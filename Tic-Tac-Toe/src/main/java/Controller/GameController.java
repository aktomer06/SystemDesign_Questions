package Controller;

import Dtos.GameRequestDto;
import Dtos.GameResponseDto;
import Models.Game;
import Services.GameService;

public class GameController {
    GameService gameService = new GameService();

    public GameResponseDto createGame(GameRequestDto gameRequestDto) {
        Game game =  gameService.createGame(gameRequestDto);
        GameResponseDto gameResponseDto = new GameResponseDto();
        gameResponseDto.setGameId(game.getGameId());

        return gameResponseDto;
    }
}
