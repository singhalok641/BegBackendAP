package tictactoe.models;

import tictactoe.exceptions.InvalidGameConstructionParametersException;
import tictactoe.factories.GameWinningStrategyFactory;
import tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;
import tictactoe.strategies.gamewinningstrategy.OrderOneGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private int nextPlayerIndex;

    private Player winner;
    private List<Move> moves;

    private GameWinningStrategy gameWinningStrategy;

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

    public Player getWinner() {
        return winner;
    }

    public void displayBoard() {
        this.board.display();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public void makeNextMove() {
        // I am picking the player whose turn it is to move
        Player toMovePlayer = players.get(nextPlayerIndex);

        System.out.println("It is " + toMovePlayer.getName() + "'s turn");

        Move move = toMovePlayer.decideMove(board); // Cell@101 -> 0,0

        // validate the move
        boolean isValidMove = validateCurrentMove(move);

        // TODO:: consider that the move is valid

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        System.out.println("Move happened at: " + row + ", " + col);

        // update the board
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        // updated my list of moves in this game
        moves.add(move);

        // Check the winner
        if(this.gameWinningStrategy.checkWinner(board, move.getCell(), toMovePlayer)){
            gameState = GameState.ENDED;
            winner = toMovePlayer;
        }

        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();
    }

    private boolean validateCurrentMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        return row >= 0 && row < board.getSize() &&
                col >= 0 && col < board.getSize() &&
                move.getCell().getCellState().equals(CellState.EMPTY);
    }

    public static class Builder {
        private int size;
        private List<Player> players;

        private GameWinningStrategy gameWinningStrategy;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setGameWinningStrategy(String winningStrategy) {
            this.gameWinningStrategy = GameWinningStrategyFactory.getGameWinningStrategy(winningStrategy, this.size);
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validate() throws InvalidGameConstructionParametersException {
            if(this.size < 3){
                throw new InvalidGameConstructionParametersException("The size of the board cannot be less than 3");
            }

            if(this.players.size() != size - 1){
                throw new InvalidGameConstructionParametersException("The number of players in the game should be board size - 1");
            }
        }

        public Game build() throws InvalidGameConstructionParametersException {
            // validations
            validate();

            Game game = new Game();
            game.setGameState(GameState.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setBoard(new Board(size));
            game.setPlayers(players);
            game.setGameWinningStrategy(this.gameWinningStrategy);

            return game;
        }
    }
}

/* 1.5 hours
Overview -> 2 mins
Requirement Gathering -> 10 - 15 min
Class Diagram and coding models -> 15 mins
Time to complete code -> 1 hr
 */
