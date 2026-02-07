/**
 * Unit tests for the {@link King} class.
 * This suite verifies the King's movement and capture capabilities:
 * <ul>
 * <li>Ensures the King cannot be placed outside the board.</li>
 * <li>Validates all 8 directions for a single-square move.</li>
 * <li>Rejects moves spanning more than one square.</li>
 * <li>Confirms capture logic follows the same movement constraints and color rules.</li>
 * </ul>
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    /**
     * Verifies that the constructor rejects invalid coordinates.
     */
    @Test
    void testConstructorExceptions() {
        assertThrows(IllegalArgumentException.class, () -> new King(8, 8, Color.WHITE));
        assertThrows(IllegalArgumentException.class, () -> new King(-1, -1, Color.BLACK));
    }

    @Test
    void testGetters() {
        King kingWhite = new King(4, 5, Color.WHITE);

        assertEquals(4, kingWhite.getRow(), "Row should match constructor input");
        assertEquals(5, kingWhite.getColumn(), "Column should match constructor input");
        assertEquals(Color.WHITE, kingWhite.getColor(), "Color should match constructor input");
    }

    /**
     * Tests that the King can move to all 8 adjacent squares.
     * Also verifies that the King cannot move multiple squares at once
     * or stay in the same position.
     */
    @Test
    void canMove() {
        King kingWhite = new King(4, 4, Color.WHITE);
        //basic case same position
        assertFalse(kingWhite.canMove(4, 4));
        //basic case out of the board
        assertFalse(kingWhite.canMove(8, 8));
        assertFalse(kingWhite.canMove(-1, -1));

        //specific case valid move (-1 -1)(-1 0)(-1 1)(0 -1)(0 1)(1 -1)(1 0)(1 1)
        assertTrue(kingWhite.canMove(3, 3));
        assertTrue(kingWhite.canMove(3, 4));
        assertTrue(kingWhite.canMove(3, 5));
        assertTrue(kingWhite.canMove(4, 3));
        assertTrue(kingWhite.canMove(4, 5));
        assertTrue(kingWhite.canMove(5, 3));
        assertTrue(kingWhite.canMove(5, 4));
        assertTrue(kingWhite.canMove(5, 5));

        //specific case invalid move
        assertFalse(kingWhite.canMove(6,4));
    }

    /**
     * Tests the King's ability to capture opponent pieces within its 1-square range.
     * Ensures it cannot capture friendly pieces.
     */
    @Test
    void canKill() {
        King kingWhite = new King(4, 4, Color.WHITE);
        //valid capture
        King kingFoe = new King(4, 5, Color.BLACK);
        assertTrue(kingWhite.canKill(kingFoe));

        //invalid capture: foe out of reach
        King kingFar1 = new King(6, 4, Color.BLACK);
        King kingFar2 = new King(2, 4, Color.BLACK);

        assertFalse(kingWhite.canKill(kingFar1));
        assertFalse(kingWhite.canKill(kingFar2));

        //invalid capture: friend
        King kingFriend1 = new King(4, 5, Color.WHITE);
        King kingFriend2 = new King(4, 3, Color.WHITE);

        assertFalse(kingWhite.canKill(kingFriend1));
        assertFalse(kingWhite.canKill(kingFriend2));
    }
}