import Command.Symbol;
import Models.Board;
import Models.ComputerPlayer;
import Models.Game;
import Models.HumanPlayer;
import Models.User;
import Strategy.EasyStrategy;
import Strategy.GreedyStrategy;

public class Client {

    public static void main(String[] args) {
        HumanPlayer humanPlayer = HumanPlayer.builder()
                .setSymbol(Symbol.X)
                .setUser(new User())
                .build();

        ComputerPlayer computerPlayer = ComputerPlayer.builder()
                .setSymbol(Symbol.O)
                .setDifficultyLevel(new EasyStrategy())
                .build();

        Game game = Game.builder()
                .setBoard(new Board(3,3))
                .addPlayer(humanPlayer)
                .addPlayer(computerPlayer)
                .setWinningStrategy(new GreedyStrategy())
                .build();
        //game.makeMove();

    }
}
