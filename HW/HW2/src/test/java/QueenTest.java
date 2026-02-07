/**
 * Unit tests for the {@link Queen} class.
 * This suite ensures the Queen's multi-directional movement works correctly:
 * <ul>
 * <li>Validates construction and boundary checks.</li>
 * <li>Tests long-range horizontal and vertical moves (Rook-like).</li>
 * <li>Tests long-range diagonal moves (Bishop-like).</li>
 * <li>Ensures the Queen cannot move in non-linear patterns (e.g., Knight-like).</li>
 * <li>Verifies capture logic against friendly and enemy pieces.</li>
 * </ul>
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    /**
     * Verifies that the constructor throws {@link IllegalArgumentException} for invalid coordinates.
     */
    @Test
    void testConstructorExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Queen(8, 8, Color.BLACK));
        assertThrows(IllegalArgumentException.class, () -> new Queen(-1, -1, Color.WHITE));
    }

    @Test
    void testGetters() {
        Queen queenWhite = new Queen(4, 5, Color.WHITE);

        assertEquals(4, queenWhite.getRow(), "Row should match constructor input");
        assertEquals(5, queenWhite.getColumn(), "Column should match constructor input");
        assertEquals(Color.WHITE, queenWhite.getColor(), "Color should match constructor input");
    }

    /**
     * Tests various valid moves (straight and diagonal) and confirms
     * that invalid "random" moves are rejected.
     */
    @Test
    void canMove() {
        //basic case same position/out of board
        Queen queenWhite = new Queen(4, 4, Color.WHITE);
        assertFalse(queenWhite.canMove(4, 4));
        assertFalse(queenWhite.canMove(8, 8));
        assertFalse(queenWhite.canMove(-1, -1));

        //specific case valid move
        assertTrue(queenWhite.canMove(7,7));
        assertTrue(queenWhite.canMove(7,4));
        assertTrue(queenWhite.canMove(4, 7));

        //specific case invalid move
        assertFalse(queenWhite.canMove(7, 5));

    }

    /**
     * Verifies the Queen can capture any enemy piece in its path
     * but is blocked from "capturing" its own teammates.
     */
    @Test
    void canKill() {
        Queen queenWhite = new Queen(4, 4, Color.WHITE);
        //valid capture
        Queen queenBlack = new Queen(5, 5, Color.BLACK);
        assertTrue(queenWhite.canKill(queenBlack));

        //invalid capture: foe out of reach
        Queen queenFar = new Queen(7, 5, Color.BLACK);
        assertFalse(queenWhite.canKill(queenFar));

        //invalid capture: friend
        Queen queenFriend = new Queen(5, 5, Color.WHITE);
        assertFalse(queenWhite.canKill(queenFriend));

    }
}