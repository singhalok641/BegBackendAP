package tictactoe.models;

import tictactoe.exceptions.InvalidGameConstructionParametersException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextPlayerIndex;

    private Player winner;
    private List<Move> moves;

    private Game(){

    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void displayBoard() {
        board.display();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void makeNextMove() {
        Player toMovePlayer = players.get(nextPlayerIndex);

        System.out.println("It is " + toMovePlayer.getName() + "'s turn");

        Move move = toMovePlayer.decideMove(board); // Cell@101 -> 0,0

        // validate the move
        boolean isValidMove = validateCurrentMove(move);

        // consider that the move is valid

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        System.out.println("Move happened at: " + row + ", " + col);

        // update the board
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        // updated my list of moves in this game
        moves.add(move);


    }

    private boolean validateCurrentMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        return row >= 0 && row < board.getSize() &&
                col >= 0 && col < board.getSize() &&
                move.getCell().getCellState().equals(CellState.EMPTY)
    }

    public static class Builder {
        private Board board;
        private List<Player> players;

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validate() throws InvalidGameConstructionParametersException {
            if(this.board.getSize() < 3){
                throw new InvalidGameConstructionParametersException("The size of the board cannot be less than 3");
            }

            if(this.players.size() != this.board.getSize() - 1){
                throw new InvalidGameConstructionParametersException("The number of players in the game should be board size - 1");
            }
        }

        public Game build() throws InvalidGameConstructionParametersException {
            // validations
            validate();

            Game game = new Game();
            game.setBoard(board);
            game.setGameState(GameState.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setPlayers(players);

            return game;
        }
    }
}
