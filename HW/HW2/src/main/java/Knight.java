/**
 * Represents a Knight chess piece.
 * The Knight moves in an 'L' shape: two squares in one cardinal direction
 * and then one square perpendicularly.
 * <p>
 * The Knight is unique because it is the only piece that can "jump" over
 * other pieces on the board.
 * </p>
 */
public class Knight extends ChessPiece {
    /**
     * Initializes a Knight with a specific position and color.
     *
     * @param row   the initial row index (0-7)
     * @param col   the initial column index (0-7)
     * @param color the color of the knight (WHITE or BLACK)
     * @throws IllegalArgumentException if the row or column is outside the 0-7 range
     */
    public Knight(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Checks if the Knight can move to the given coordinates based on the L-shape rule.
     * Valid moves consist of a 2x1 or 1x2 grid displacement.
     *
     * @param row the target row index
     * @param col the target column index
     * @return true if the move is a valid L-shape, false otherwise
     */
    @Override
    public boolean canMove(int row, int col) {
        // basic validation: can not move outside the board or stay in the same place
        if (!isWithinBoard(row, col) || (row == this.row && col == this.col)) {
            return false;
        }
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.col);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

}
