/**
 * Represents a King chess piece.
 * The King is the most important piece in chess. It moves exactly one square
 * in any direction: horizontally, vertically, or diagonally.
 * <p>
 * While the King's range is limited, it can move to any of the 8 adjacent squares
 * surrounding its current position.
 * </p>
 */
public class King extends ChessPiece {
    /**
     * Initializes a King with a specific position and color.
     *
     * @param row   the initial row index (0-7)
     * @param col   the initial column index (0-7)
     * @param color the color of the king (WHITE or BLACK)
     * @throws IllegalArgumentException if the position is outside the 0-7 chessboard range
     */
    public King(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Validates if the King can move to the specified target.
     * A valid move is defined as any square where the absolute difference
     * in both row and column is at most 1, excluding the current position.
     *
     * @param row target row index
     * @param col target column index
     * @return true if the target is exactly one square away, false otherwise
     */
    @Override
    public boolean canMove(int row, int col) {
        // basic validation
        if (!isWithinBoard(row, col) || (row == this.row && col == this.col)) {
            return false;
        }

        // specific validation
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.col);
        return rowDiff <= 1 && colDiff <= 1;
    }
}
