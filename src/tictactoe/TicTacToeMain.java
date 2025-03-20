package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GameController gameController = new GameController();
        System.out.println("=========== Welcome to Tic Tac Toe ============");
        System.out.println("What is the dimension of the game?");
        int size = in.nextInt();

        System.out.println("Will there be a bot in the game? y/n");
        String isBotString = in.next();

        List<Player> players = new ArrayList<>();

        int toIterate = size - 1;

        if(isBotString.equals("y")){
            toIterate -= 1;
        }

        for(int i=1; i<=toIterate; i++){
            System.out.println("What is the name of the player?" + i);
            String playerName = in.next();

            System.out.println("What is the symbol for this player?" + i);
            char playerSymbol = in.next().charAt(0);

            players.add(new Player(playerName, playerSymbol, PlayerType.HUMAN));
        }

        if(isBotString.equals("y")){
            System.out.println("What is the name of the bot? ");
            String botName = in.next();

            System.out.println("What is the symbol for this bot? ");
            char botSymbol = in.next().charAt(0);

            players.add(new Bot(botName, botSymbol, BotDifficultyLevel.EASY));
        }

        Game game = gameController.createGame(size, players);

        // I want to check the gameStatus consistently
        // If the game status is IN_PROGRESS
        // Else come out of the while loop
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            System.out.println("This is your current board");
            gameController.displayBoard(game);

            gameController.executeGame(game);

        }


    }
}
