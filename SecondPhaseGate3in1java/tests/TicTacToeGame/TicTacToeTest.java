package TicTacToeGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testMakeMoveForPlayer1() {
        game.moves(CurrentState.X, 5);
        assertEquals(CurrentState.X, game.getBoard()[1][1]);
    }

    @Test
    public void testMakeMoveForPlayer2() {
        game.moves(CurrentState.O, 2);
        assertEquals(CurrentState.O, game.getBoard()[0][1]);
    }

    @Test
    public void testCheckWinner() {
        game.moves(CurrentState.X, 1);
        game.moves(CurrentState.O, 4);
        game.moves(CurrentState.X, 2);
        game.moves(CurrentState.O, 7);
        game.moves(CurrentState.X, 3);
        assertEquals(CurrentState.X, game.checkWinner());
    }

    @Test
    public void testCheckWinnerForDiagonal() {
        game.moves(CurrentState.O, 1);
        game.moves(CurrentState.X, 4);
        game.moves(CurrentState.O, 5);
        game.moves(CurrentState.X, 7);
        game.moves(CurrentState.O  , 9);
        assertEquals(CurrentState.O, game.checkWinner());
    }





}