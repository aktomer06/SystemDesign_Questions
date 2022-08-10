package Services;

import Dtos.MoveRequestDto;
import Models.BoardCell;
import Models.Game;
import Repositories.GameRepository;

import java.security.InvalidParameterException;

public class BoardService {

    public void makeMove(MoveRequestDto moveRequestDto) {
        Game game = GameRepository.getInstance().findById(moveRequestDto.getGameId());
        if(game != null) {
            game.makeMove(new BoardCell(moveRequestDto.getRows(), moveRequestDto.getCols()), moveRequestDto.getPlayerId());//TODO
        }
        throw new InvalidParameterException("No Game found");
    }
    public void printBoard(Integer gameId) {
        Game game =  GameRepository.getInstance().findById(gameId);
        game.getBoard().printBoard();
    }

    public void checkWinner(Integer gameId) {
        Game game =  GameRepository.getInstance().findById(gameId);

        if(game != null) {
                game.getWinningStrategy().checkWinner(game);
        }
        else {
            throw new InvalidParameterException("Game is not valid");
        }

    }
}
