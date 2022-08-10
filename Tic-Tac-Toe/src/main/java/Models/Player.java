package Models;

import Command.Symbol;

public abstract class Player {

    private int playerId;
    public Symbol symbol;

    public abstract Models.Board makeMove(Models.Board board, Models.BoardCell boardCell);
}
