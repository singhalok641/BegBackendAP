package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        /*
        [cell(0,0), cell(0,1), cell(0,2)],
        [cell(1,0), cell(1,1), cell(1,2)],
        [cell(2,0), cell(2,1), cell(2,2)],
         */
        for(int i=0; i<size; i++){
            this.board.add(new ArrayList<>());
            for(int j=0; j<size; j++){
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void display(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    System.out.printf("|   |");
                }
                else {
                    System.out.printf("| " + board.get(i).get(j).getPlayer().getSymbol() + " |");
                }
            }
            System.out.println("\n");
        }
    }
}
