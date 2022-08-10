package Strategy;

import Models.Game;

public interface WinningStrategy {
    void checkWinner(Game game);
}
