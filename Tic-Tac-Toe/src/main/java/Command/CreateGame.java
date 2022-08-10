package Command;

import Controller.GameController;
import Dtos.GameRequestDto;
import Dtos.GameResponseDto;
import Dtos.PlayerDto;
import Constants.PlayerType;
import Constants.DifficultyLevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateGame implements Command {
    @Override
    public GameResponseDto execute(Integer gameId) {
        System.out.println("Welcome to Tic-Tac-Toc Game...");
        System.out.println("Please Enter Board Dimension [2 2] or [3 3]");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        List<PlayerDto> playerTypeList = new ArrayList<>();
        try {
            for(int i = 0; i < 2; i++) {
                PlayerDto player = new PlayerDto();
                System.out.println("Please choose Player [Human, Computer]");
                String playerType = reader.readLine();
                if(playerType.equals("Human")) {
                    player.setPlayerType(PlayerType.HUMAN);
                }
                else if(playerType.equals("Computer")) {
                    player.setPlayerType(PlayerType.COMPUTER);
                    System.out.println("Please enter difficulty level for Computer player");
                    String difficultyLevel = reader.readLine();
                    if(difficultyLevel.equals("Easy")) {
                        player.setDifficultyLevel(DifficultyLevel.EASY);
                    }
                    else if(difficultyLevel.equals("Medium")) {
                        player.setDifficultyLevel(DifficultyLevel.Medium);
                    }
                    else {
                        throw new InvalidParameterException("Difficulty level is not valid");
                    }

                }
                else {
                    throw new InvalidParameterException("Player Type is not valid");
                }

                System.out.println("Please enter symbol for Player");
                String symbol = reader.readLine();

                if (symbol.equals("X")) {
                    player.setSymbol(Symbol.X);
                }
                else if(symbol.equals("O")) {
                    player.setSymbol(Symbol.O);
                }
                else {
                    throw new InvalidParameterException("Symbol is not valid");
                }
                playerTypeList.add(player);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        GameRequestDto gameRequestDto = GameRequestDto.builder()
                .setBoardDimension(row, col)
                .setPlayerList(playerTypeList)
                .build();

        GameController gameController = new GameController();
        return gameController.createGame(gameRequestDto);
    }

    @Override
    public boolean matches(String string) {
        if(string.equals(CommandKeyWords.createGameCmd)) {
            return true;
        }
        else{
            return false;
        }
    }
}
