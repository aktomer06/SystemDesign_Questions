package Models;

public class PlayerFactory {
    public static Models.HumanPlayer.Builder createHumanPlayer() {
        return Models.HumanPlayer.builder();
    }

    public static Models.ComputerPlayer.Builder createComputerPlayer() {
        return Models.ComputerPlayer.builder();
    }
    private PlayerFactory() {

    }

}
