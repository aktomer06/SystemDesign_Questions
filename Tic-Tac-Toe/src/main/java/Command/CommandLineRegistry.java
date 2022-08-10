package Command;
import Dtos.GameResponseDto;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CommandLineRegistry {
    private List<Command> commandList = new ArrayList<>();

    public void register(Command command) {
        commandList.add(command);
    }
    public GameResponseDto executeCommand(String input, Integer gameId) {
        for(Command c : commandList) {
            if(c.matches(input)) {
                return c.execute(gameId);
            }
        }
        throw new InvalidParameterException("Command is not valid");
    }
}
