package tictactoe.strategies.gamewinningstrategy;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board,
                        Cell moveCell,
                        Player player);
}