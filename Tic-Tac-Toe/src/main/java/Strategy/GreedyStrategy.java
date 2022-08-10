package Strategy;

import Models.BoardCell;
import Models.Game;

import static java.lang.System.exit;

public class GreedyStrategy implements Strategy.WinningStrategy {
    boolean checkRows(Game game) {
        BoardCell[][] cells = game.getBoard().getCells();
        for (int i = 0; i < game.getPlayerList().size(); i++) {
            int count = 0;
            int rows = cells.length;
            int cols = cells[0].length;
            for (int j = 0; j < cols; j++) {
                if (game.getPlayerList().get(i).symbol == cells[0][j].symbol) {
                    count++;
                }
            }
            if (count == rows) {
                System.out.println("PLAYER " + i + " IS THE WINNER");
                return true;
            }
        }
        return false;
    }
    boolean checkCols(Game game) {
        BoardCell[][] cells = game.getBoard().getCells();
        for (int i = 0; i < game.getPlayerList().size(); i++) {
            int count = 0;
            int rows = cells.length;
            int cols = cells[0].length;
            for (int j = 0; j < rows; j++) {
                if (game.getPlayerList().get(i).symbol == cells[j][0].symbol) {
                    count++;
                }
            }
            if (count == rows) {
                System.out.println("PLAYER " + i + " IS THE WINNER");
                return true;
            }
        }
        return false;
    }
    boolean checkDiagonal(Game game) {
        BoardCell[][] cells = game.getBoard().getCells();
        for (int i = 0; i < game.getPlayerList().size(); i++) {
            int count = 0;
            int rows = cells.length;
            int cols = cells[0].length;
            for (int j = 0; j < rows; j++) {
                if (game.getPlayerList().get(i).symbol == cells[j][j].symbol) {
                    count++;
                }
            }
            if (count == rows) {
                System.out.println("PLAYER " + i + " IS THE WINNER");
                return true;
            }
        }
        return false;
    }
    @Override
    public void checkWinner(Game game) {
        if(checkRows(game) ||  checkCols(game) || checkDiagonal(game)) {
            exit(0);
        }
        else if(game.getBoard().filledCells == game.getBoard().getCells().length*game.getBoard().getCells()[0].length) {
            System.out.println("GAME IS DRAW");
            exit(0);
        }
    }
}
