package Strategy;

import Models.Board;
import Models.BoardCell;
import Command.Symbol;

public interface DifficultyStrategy {

    Board move(Board board, BoardCell boardCell, Symbol symbol);
}
