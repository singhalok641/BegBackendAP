package tictactoe.strategies.botplayingstrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
