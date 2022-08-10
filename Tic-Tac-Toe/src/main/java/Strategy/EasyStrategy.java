package Strategy;

import Models.Board;
import Models.BoardCell;
import Command.Symbol;

import java.security.InvalidParameterException;

public class EasyStrategy implements Strategy.DifficultyStrategy {

    @Override
    public Board move(Board board, BoardCell boardCell, Symbol symbol) {
        System.out.println("Making move as per Easy strategy with symbol " + symbol);
        BoardCell[][] cells = board.getCells();
        if(boardCell.row < cells.length && boardCell.col < cells[boardCell.row].length && cells[boardCell.row][boardCell.col].symbol == Symbol.E) {
            cells[boardCell.row][boardCell.col].symbol = symbol;
            board.filledCells++;
        }
        else {
            throw new InvalidParameterException("Not a valid move, try again");
        }
        return board;
    }
}
