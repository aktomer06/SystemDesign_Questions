package Strategy;

import Models.Board;
import Models.BoardCell;
import Command.Symbol;

import java.security.InvalidParameterException;

public class MediumStrategy implements Strategy.DifficultyStrategy {

    @Override
    public Board move(Board board, BoardCell boardCell, Symbol symbol) {
        System.out.println("Making move as per Medium strategy with symbol " + symbol);
        throw new InvalidParameterException("Strategy is not implemented");
        //return board;
    }
}
