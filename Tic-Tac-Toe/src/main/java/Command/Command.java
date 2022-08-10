package Command;

import Dtos.GameResponseDto;

public interface Command {
    public abstract GameResponseDto execute(Integer gameId);
    public abstract boolean matches(String string);
}
