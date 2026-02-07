/**
 * Unit tests for the {@link Bishop} class.
 * This suite verifies the Bishop's diagonal movement and capture logic:
 * <ul>
 * <li>Ensures the Bishop is correctly placed on the board during construction.</li>
 * <li>Tests valid diagonal moves in all four directions (NE, NW, SE, SW).</li>
 * <li>Confirms that horizontal and vertical moves are correctly rejected.</li>
 * <li>Verifies the capture logic for enemy pieces and protection of friendly pieces.</li>
 * </ul>
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BishopTest {
    /**
     * Tests that the constructor correctly identifies illegal board coordinates.
     */
    @Test
    void testConstructorExceptions() {
        //basic case
        assertThrows(IllegalArgumentException.class, () -> new Bishop(8, 8, Color.BLACK));
        assertThrows(IllegalArgumentException.class, () -> new Bishop(-1, -1, Color.WHITE));
    }

    @Test
    void testGetters() {
        Bishop bishopWhite = new Bishop(4, 5, Color.WHITE);

        assertEquals(4, bishopWhite.getRow(), "Row should match constructor input");
        assertEquals(5, bishopWhite.getColumn(), "Column should match constructor input");
        assertEquals(Color.WHITE, bishopWhite.getColor(), "Color should match constructor input");
    }

    /**
     * Verifies that the Bishop can move diagonally across various distances
     * and ensures non-diagonal moves return false.
     */
    @Test
    void canMove() {
        Bishop bishopWhite = new Bishop(4, 4, Color.WHITE);
        //basic case same position
        assertFalse(bishopWhite.canMove(4, 4));
        //basic case out of the board
        assertFalse(bishopWhite.canMove(8, 8));
        assertFalse(bishopWhite.canMove(-1, -1));
        //specific case valid move diagonally
        assertTrue(bishopWhite.canMove(5, 5));
        assertTrue(bishopWhite.canMove(5, 3));
        assertTrue(bishopWhite.canMove(3, 3));
        assertTrue(bishopWhite.canMove(3, 5));
        //specific case invalid move straight forward/backward
        assertFalse(bishopWhite.canMove(5, 4));
        assertFalse(bishopWhite.canMove(3, 4));
    }

    /**
     * Tests the Bishop's ability to capture opponent pieces located on its diagonal path.
     * Confirms that it cannot capture pieces of the same color.
     */
    @Test
    void canKill() {
        //valid capture: foe within valid area
        Bishop bishopBlack = new Bishop(4, 4, Color.BLACK);
        Bishop bishopWhite = new Bishop(5, 5, Color.WHITE);
        assertTrue(bishopBlack.canKill(bishopWhite));

        //invalid capture: foe out of reach
        Bishop bishopForward = new Bishop(5, 4, Color.WHITE);
        Bishop bishopBackward = new Bishop(3, 4, Color.WHITE);
        assertFalse(bishopBlack.canKill(bishopForward));
        assertFalse(bishopBlack.canKill(bishopBackward));

        //invalid capture: friend
        Bishop bishopFriend = new Bishop(5, 5, Color.BLACK);
        assertFalse(bishopBlack.canKill(bishopFriend));
    }

}