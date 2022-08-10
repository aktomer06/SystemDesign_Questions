package Models;

import Command.Symbol;
import Strategy.DifficultyStrategy;

public class ComputerPlayer extends Models.Player {
    DifficultyStrategy difficultyStrategy;
    private ComputerPlayer() {
    }

    public static Builder builder() {
        return new Builder();
    }
    @Override
    public Models.Board makeMove(Models.Board board, Models.BoardCell boardCell) {
        return difficultyStrategy.move(board, boardCell, this.symbol);
    }

    public static class Builder {
        ComputerPlayer computerPlayer = new ComputerPlayer();

        public Builder setDifficultyLevel(DifficultyStrategy difficultyStrategy) {
            computerPlayer.difficultyStrategy = difficultyStrategy;
            return this;
        }
        public Builder setSymbol(Symbol symbol) {
            computerPlayer.symbol = symbol;
            return this;
        }
        public ComputerPlayer build() {
            return computerPlayer;
        }
    }
}
