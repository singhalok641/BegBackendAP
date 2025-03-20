package tictactoe.controllers;

import tictactoe.exceptions.InvalidGameConstructionParametersException;
import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int size, List<Player> players) {
        try {
            return Game.getBuilder()
                    .setBoard(new Board(size))
                    .setPlayers(players)
                    .build();
        }
        catch (Exception e) {
            // You can add some proper message for the client here
            System.out.println(e);
        }
        return null;
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void executeGame(Game game){
        game.makeNextMove();
    }
}
