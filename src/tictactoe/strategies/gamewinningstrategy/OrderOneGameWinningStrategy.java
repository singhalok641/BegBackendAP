package tictactoe.strategies.gamewinningstrategy;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
List of hashmaps for all the cols
List of hashmaps for all the rows
A hashmap for L-R diagonal
A hashmap for R-L diagonal
 */
public class OrderOneGameWinningStrategy implements GameWinningStrategy{
    //        0             1                  2
    // [{X -> 1, O -> 2}], [{X -> 2, O -> 0}], [....]
    private List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();
    private List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();
    private HashMap<Character, Integer> topLeftDiagonalSymbolCounts = new HashMap<>();
    private HashMap<Character, Integer> topRightDiagonalSymbolCounts = new HashMap<>();

    public OrderOneGameWinningStrategy(int size) {
        for(int i=0;i<size;i++){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }

    private boolean isCellOnTopLeftDiagonal(int row, int col){
        return row == col;
    }

    private boolean isCellOnTopRightDiagonal(int row, int col, int size){
        return row + col == size - 1;
    }

    @Override
    public boolean checkWinner(Board board, Cell moveCell, Player player) {
        char symbol = moveCell.getPlayer().getSymbol();
        int row = moveCell.getRow();
        int col = moveCell.getCol();
        int size = board.getSize();

        // If my hashmap is not initialised with the symbol(e.g X) for this player
        if(!rowSymbolCounts.get(row).containsKey(symbol)){
            rowSymbolCounts.get(row).put(symbol, 0);
        }

        // If already initialised, then just increment the count
        rowSymbolCounts.get(row).put(
                symbol, rowSymbolCounts.get(row).get(symbol) + 1
        );


        // Similar check in col done as done in rows hashmap
        if(!colSymbolCounts.get(col).containsKey(symbol)){
            colSymbolCounts.get(col).put(symbol, 0);
        }

        colSymbolCounts.get(col).put(
                symbol, colSymbolCounts.get(col).get(symbol) + 1
        );

        if(isCellOnTopLeftDiagonal(row, col)) {
            if(!topLeftDiagonalSymbolCounts.containsKey(symbol)){
                topLeftDiagonalSymbolCounts.put(symbol, 0);
            }

            topLeftDiagonalSymbolCounts.put(
                    symbol, topLeftDiagonalSymbolCounts.get(symbol) + 1
            );
        }

        if(isCellOnTopRightDiagonal(row, col, size)) {
            if(!topRightDiagonalSymbolCounts.containsKey(symbol)){
                topRightDiagonalSymbolCounts.put(symbol, 0);
            }

            topRightDiagonalSymbolCounts.put(
                    symbol, topRightDiagonalSymbolCounts.get(symbol) + 1
            );
        }


        if(rowSymbolCounts.get(row).get(symbol) == size ||
            colSymbolCounts.get(col).get(symbol) == size) {
            return true;
        }

        if(isCellOnTopRightDiagonal(row, col, size) &&
                topRightDiagonalSymbolCounts.get(symbol) == size) return true;

        if(isCellOnTopLeftDiagonal(row, col) &&
                topLeftDiagonalSymbolCounts.get(symbol) == size) return true;

        return false;
    }
}
