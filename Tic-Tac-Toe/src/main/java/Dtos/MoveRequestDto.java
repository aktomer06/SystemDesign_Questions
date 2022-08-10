package Dtos;

public class MoveRequestDto {
    private Integer gameId;
    private Integer rows;
    private Integer cols;
    private Integer playerId;

    private MoveRequestDto() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public static class Builder {
        MoveRequestDto moveRequestDto = new MoveRequestDto();

        public Builder setGameId(Integer gameId) {
            moveRequestDto.gameId = gameId;
            return this;
        }
        public Builder setDimension(Integer rows, Integer cols) {
            moveRequestDto.rows = rows;
            moveRequestDto.cols = cols;
            return this;
        }

        public Builder setPlayerID(Integer playerID) {
            moveRequestDto.playerId = playerID;
            return this;
        }

        public MoveRequestDto build() {
            return this.moveRequestDto;
        }
    }

}
