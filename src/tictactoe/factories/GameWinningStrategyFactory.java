package tictactoe.factories;

import tictactoe.models.Game;
import tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;
import tictactoe.strategies.gamewinningstrategy.OrderOneGameWinningStrategy;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(String winningStrategy, int size){
        if(winningStrategy.equals("OrderOne")){
            return new OrderOneGameWinningStrategy(size);
        }
        return null;
    }
}
