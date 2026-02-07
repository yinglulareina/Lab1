/**
 * Unit tests for the {@link Rook} class.
 * This suite ensures the Rook's linear movement is correctly implemented:
 * <ul>
 * <li>Verifies correct instantiation and coordinate validation.</li>
 * <li>Tests long-range vertical moves along a single column.</li>
 * <li>Tests long-range horizontal moves along a single row.</li>
 * <li>Ensures diagonal and non-linear moves (like Knight jumps) are rejected.</li>
 * <li>Validates capture logic against different piece colors.</li>
 * </ul>
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    /**
     * Confirms that attempting to place a Rook outside the 8x8 grid
     * results in an {@link IllegalArgumentException}.
     */
    @Test
    void testConstructorExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Rook(8, 8, Color.WHITE));
        assertThrows(IllegalArgumentException.class, () -> new Rook(-1, -1, Color.BLACK));
    }

    @Test
    void testGetters() {
        Rook rookWhite = new Rook(4, 5, Color.WHITE);

        assertEquals(4, rookWhite.getRow(), "Row should match constructor input");
        assertEquals(5, rookWhite.getColumn(), "Column should match constructor input");
        assertEquals(Color.WHITE, rookWhite.getColor(), "Color should match constructor input");
    }

    /**
     * Tests that the Rook can move to any square in its current row or column,
     * but returns false for diagonal or arbitrary square attempts.
     */
    @Test
    void canMove() {
        //basic case same position/out of board
        Rook rookWhite = new Rook(4, 4, Color.WHITE);
        assertFalse(rookWhite.canMove(4, 4));
        assertFalse(rookWhite.canMove(-1, -1));

        //specific case valid move
        assertTrue(rookWhite.canMove(6, 4));
        assertTrue(rookWhite.canMove(4, 6));

        //specific case invalid move
        assertFalse(rookWhite.canMove(5, 5));
        assertFalse(rookWhite.canMove(6, 5));
    }

    /**
     * Verifies the Rook's ability to capture enemy pieces along its path.
     * Also ensures that the Rook cannot capture pieces of the same color.
     */
    @Test
    void canKill() {
        Rook rookWhite = new Rook(4, 4, Color.WHITE);
        //valid capture
        Rook rookBlack = new Rook(5, 4, Color.BLACK);
        assertTrue(rookWhite.canKill(rookBlack));

        //invalid capture - foe out of reach
        Rook rookFar = new Rook(7, 5, Color.BLACK);
        assertFalse(rookWhite.canKill(rookFar));

        //invalid capture - friend
        Rook rookFriend = new Rook(7, 4, Color.WHITE);
        assertFalse(rookWhite.canKill(rookFriend));
    }
}