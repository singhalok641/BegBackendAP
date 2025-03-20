package tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType playerType;

    private Scanner scanner;

    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideMove(Board board) {
        System.out.println("Which row you want to move, starting from 0: ");
        int row = scanner.nextInt();

        System.out.println("Which col you want to move, starting from 0: ");
        int col = scanner.nextInt();

        Cell currentCell = board.getBoard().get(row).get(col);

        return new Move(this, currentCell);
    }
}

// Move  -> player  -> Alok, cell -> 1,3

