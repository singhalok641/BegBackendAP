package tictactoe.strategies.botplayingstrategy;

import tictactoe.models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {
        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j<board.getSize(); j++){
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    return new Move(player, board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
