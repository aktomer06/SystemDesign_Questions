package Dtos;

import java.security.InvalidParameterException;
import java.util.List;

public class GameRequestDto {
    private List<Dtos.PlayerDto> playerList;
    private int rows;
    private int cols;

    private GameRequestDto() {

    }

    public List<Dtos.PlayerDto> getPlayerList() {
        return playerList;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private GameRequestDto gameRequestDto = new GameRequestDto();

        public Builder setPlayer(Dtos.PlayerDto playerDto) {
            gameRequestDto.playerList.add(playerDto);
            return this;
        }
        public Builder setPlayerList(List<Dtos.PlayerDto> playerList) {
            gameRequestDto.playerList = playerList;
            return this;
        }

        public Builder setBoardDimension(Integer rows, int cols) {
            gameRequestDto.rows = rows;
            gameRequestDto.cols = cols;
            return this;
        }

        public GameRequestDto build() {
            if(gameRequestDto.playerList.size() > 2) {
                throw new InvalidParameterException("Player should be less than or equal to 2");
            }
            if(gameRequestDto.rows < 2  || gameRequestDto.cols < 2) {
                throw new InvalidParameterException("Board Dimension is not valid");
            }
            return gameRequestDto;
        }
    }
}
