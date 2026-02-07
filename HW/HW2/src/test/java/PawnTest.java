/**
 * Test suite for the {@link Pawn} class.
 * Verifies forward movement, double-stepping from origin,
 * diagonal captures, and illegal backward/horizontal moves.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.BeforeEach.*;


class PawnTest {
    /**
     * Verifies that the constructor correctly identifies illegal pawn placements
     * such as out-of-bounds or forbidden rows (0 for White, 7 for Black).
     */
    @Test
    void testConstructorExceptions() {
        //basic case(Note 1)
        assertThrows(IllegalArgumentException.class, () -> new Pawn(8, 0, Color.WHITE));
        //specific case(Note 2)
        assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 4, Color.WHITE));
        assertThrows(IllegalArgumentException.class, () -> new Pawn(7, 4, Color.BLACK));
    }

    @Test
    void testGetters() {
        Pawn pawnWhite = new Pawn(4, 5, Color.WHITE);

        assertEquals(4, pawnWhite.getRow(), "Row should match constructor input");
        assertEquals(5, pawnWhite.getColumn(), "Column should match constructor input");
        assertEquals(Color.WHITE, pawnWhite.getColor(), "Color should match constructor input");
    }

    /**
     * Tests standard forward movement and the special initial two-step move.
     */
    @Test
    void canMove() {
        Pawn whitePawn = new Pawn(1, 4, Color.WHITE);
        //two steps for the first move
        assertTrue(whitePawn.canMove(3, 4));
        //one step for the first move
        assertTrue(whitePawn.canMove(2, 4));
        //more than two steps for the first move
        assertFalse(whitePawn.canMove(4, 4));
        //diagonally move
        assertFalse(whitePawn.canMove(2, 5));
        assertFalse(whitePawn.canMove(2, 3));
        assertFalse(whitePawn.canMove(0, 5));
        assertFalse(whitePawn.canMove(0, 3));
        //backward move
        assertFalse(whitePawn.canMove(0, 4));

        Pawn whiteOnlyOne = new Pawn(2, 4, Color.WHITE);
        //can only move one step
        assertTrue(whiteOnlyOne.canMove(3, 4));
        //can not move more than one step
        assertFalse(whiteOnlyOne.canMove(4, 4));
    }

    /**
     * Tests the pawn's unique capture rule (diagonal only) and
     * ensures it cannot capture pieces directly in front.
     */
    @Test
    void canKill() {
        //all kinds of targets
        Pawn whitePawn = new Pawn(4, 4, Color.WHITE);
        Pawn blackRight = new Pawn(5, 5, Color.BLACK);//right target
        Pawn blackLeft = new Pawn(5, 3, Color.BLACK);//left target
        Pawn blackFar = new Pawn(6, 5, Color.BLACK);//target beyond reach

        //valid capture
        assertTrue(whitePawn.canKill(blackRight));
        assertTrue(whitePawn.canKill(blackLeft));

        //invalid capture - out of reach
        Pawn blackFront = new Pawn(5, 4, Color.BLACK);
        assertFalse(whitePawn.canKill(blackFar));
        assertFalse(whitePawn.canKill(blackFront));

        //invalid capture - friend
        Pawn whiteFriend = new Pawn(5, 5, Color.WHITE);
        assertFalse(whitePawn.canKill(whiteFriend));
    }
}