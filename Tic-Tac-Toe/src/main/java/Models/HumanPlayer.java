package Models;

import Command.Symbol;

import java.security.InvalidParameterException;

public class HumanPlayer extends Models.Player {
    Models.User user;
    private HumanPlayer() {
    }

    public static Builder builder() {
        return new Builder();
    }
    @Override
    public Models.Board makeMove(Models.Board board, Models.BoardCell cell) {
        System.out.println("Human Player with Symbol " + symbol);
        Models.BoardCell[][] cells = board.getCells();
        //board.printBoard();
        if(cell.row < cells.length && cell.col < cells[cell.row].length && cells[cell.row][cell.col].symbol == Symbol.E) {
            cells[cell.row][cell.col].symbol = symbol;
            board.filledCells++;
        }
        else {
            throw new InvalidParameterException("Not a valid move, try again");
        }
        return board;
    }

    public static class Builder {
        HumanPlayer humanPlayer = new HumanPlayer();

        public Builder setUser(Models.User user) {
            humanPlayer.user = user;
            return this;
        }
        public Builder setSymbol(Symbol symbol) {
            humanPlayer.symbol = symbol;
            return this;
        }

        public HumanPlayer build() {
            return humanPlayer;
        }
    }
}
