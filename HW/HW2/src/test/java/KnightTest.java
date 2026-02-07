/**
 * Unit tests for the {@link Knight} class.
 * This suite ensures that the Knight:
 * <ul>
 * <li>Validates its coordinates during construction.</li>
 * <li>Correcty identifies all 8 possible L-shape moves from a central position.</li>
 * <li>Rejects moves that do not follow the L-shape pattern.</li>
 * <li>Correcty handles capturing logic based on piece color.</li>
 * </ul>
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    /**
     * Verifies that the constructor throws {@link IllegalArgumentException}
     * for coordinates outside the 0-7 chessboard range.
     */
    @Test
    void testConstructorExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Knight(9, 9, Color.BLACK));
        assertThrows(IllegalArgumentException.class, () -> new Knight(-2, -2, Color.WHITE));
    }

    @Test
    void testGetters() {
        Knight knightWhite = new Knight(4, 5, Color.WHITE);

        assertEquals(4, knightWhite.getRow(), "Row should match constructor input");
        assertEquals(5, knightWhite.getColumn(), "Column should match constructor input");
        assertEquals(Color.WHITE, knightWhite.getColor(), "Color should match constructor input");
    }

    /**
     * Tests all 8 valid L-shape movements for a Knight positioned at (4,4).
     * Also verifies that staying in place or moving out of bounds returns false.
     */
    @Test
    void canMove() {
        //basic case same position/out of board
        Knight knightBlack = new Knight(4, 4, Color.BLACK);
        assertFalse(knightBlack.canMove(4, 4));
        assertFalse(knightBlack.canMove(-1, -1));

        //specific case valid move
        assertTrue(knightBlack.canMove(6, 5));
        assertTrue(knightBlack.canMove(6, 3));
        assertTrue(knightBlack.canMove(2, 5));
        assertTrue(knightBlack.canMove(2, 3));
        assertTrue(knightBlack.canMove(5, 6));
        assertTrue(knightBlack.canMove(5, 2));
        assertTrue(knightBlack.canMove(3, 6));
        assertTrue(knightBlack.canMove(3, 2));

        //specific case invalid move
        assertFalse(knightBlack.canMove(6, 4));
        assertFalse(knightBlack.canMove(2, 4));
        assertFalse(knightBlack.canMove(4, 6));
        assertFalse(knightBlack.canMove(4, 2));
        assertFalse(knightBlack.canMove(5, 5));
        assertFalse(knightBlack.canMove(3, 3));
        assertFalse(knightBlack.canMove(5, 3));
        assertFalse(knightBlack.canMove(3, 5));
    }

    /**
     * Tests the capture logic inherited from {@link ChessPiece}.
     * Ensures the Knight can capture enemy pieces but cannot capture friendly pieces
     * at valid L-shape destinations.
     */
    @Test
    void canKill() {
        Knight knightWhite = new Knight(4, 4, Color.WHITE);
        //valid capture
        Knight knightFoe = new Knight(6, 5, Color.BLACK);
        assertTrue(knightWhite.canKill(knightFoe));

        //invalid capture: foe out of reach
        Knight knightFar1 = new Knight(6, 4, Color.BLACK);
        Knight knightFar2 = new Knight(2, 4, Color.BLACK);

        assertFalse(knightWhite.canKill(knightFar1));
        assertFalse(knightWhite.canKill(knightFar2));

        //invalid capture: friend
        Knight knightFriend1 = new Knight(6, 5, Color.WHITE);
        Knight knightFriend2 = new Knight(6, 3, Color.WHITE);

        assertFalse(knightWhite.canKill(knightFriend1));
        assertFalse(knightWhite.canKill(knightFriend2));
    }
}