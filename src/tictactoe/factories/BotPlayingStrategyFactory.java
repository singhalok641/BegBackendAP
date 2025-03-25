package tictactoe.factories;

import tictactoe.models.BotDifficultyLevel;
import tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;
import tictactoe.strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new RandomBotPlayingStrategy();
        }
        return null;
    }
}
