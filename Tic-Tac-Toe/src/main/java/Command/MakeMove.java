package Command;

import Controller.BoardController;
import Dtos.GameResponseDto;
import Dtos.MoveRequestDto;

import java.util.Scanner;

public class MakeMove implements Command {

    @Override
    public boolean matches(String string) {
        if(string.equals(CommandKeyWords.makeMove)) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public GameResponseDto execute(Integer gameId) {
        //board.printBoard();
        BoardController boardController = new BoardController();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (true) {
            boardController.printBoard(gameId);
            if (flag) {
                flag = false;
                System.out.println("Player::1 Chance:: Enter row and column number...: ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                try {
                    boardController.makeMove(MoveRequestDto.builder()
                            .setPlayerID(0)
                            .setGameId(gameId)
                            .setDimension(row, col)
                            .build());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                flag = true;
                System.out.println("Player::2  Chance:: Enter row and column number...: ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                try {
                    boardController.makeMove(MoveRequestDto.builder()
                            .setPlayerID(1)
                            .setGameId(gameId)
                            .setDimension(row, col)
                            .build());

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            boardController.checkWinner(gameId);
        }
//            //System.out.println("board.filledCells = " + board.filledCells + " board.cells.length = " + board.cells.length + " board.cells[0].length " + board.cells[0].length);
//            if(board.filledCells != board.cells.length * board.cells[0].length)
//            {
//                winningStrategy.checkWinner(this);
//            }
//        }
//        MoveRequestDto moveRequestDto = new MoveRequestDto(gameId);
//        return boardController.makeMove(moveRequestDto);
    }
}
