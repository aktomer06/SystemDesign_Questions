package Controller;

import Dtos.GameResponseDto;
import Dtos.MoveRequestDto;
import Services.BoardService;

public class BoardController {
    BoardService boardService = new BoardService();
    public GameResponseDto makeMove(MoveRequestDto moveRequestDto) {
        boardService.makeMove(moveRequestDto);
        GameResponseDto gameResponseDto = new GameResponseDto();

        return gameResponseDto;
    }
    public void printBoard(Integer gameId) {
        boardService.printBoard(gameId);
    }

    public void checkWinner(Integer gameId) {
        boardService.checkWinner(gameId);
    }
}
