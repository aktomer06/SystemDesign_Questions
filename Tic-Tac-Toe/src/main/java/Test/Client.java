package Test;

import Command.CommandLineRegistry;
import Command.CreateGame;
import Command.MakeMove;
import Dtos.GameResponseDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) {
        CommandLineRegistry commandLineRegistry = new CommandLineRegistry();
        commandLineRegistry.register(new CreateGame());
        commandLineRegistry.register(new MakeMove());
        GameResponseDto gameResponseDto = new GameResponseDto();
        while(true) {
            System.out.println("Enter command : [CreateGame MakeMove]");
            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                gameResponseDto = commandLineRegistry.executeCommand(input, gameResponseDto.getGameId());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
