/**
 * Represents a Queen chess piece.
 * The Queen is the most powerful piece in chess, combining the movement
 * capabilities of both the {@link Rook} and the {@link Bishop}.
 * <p>
 * It can move any number of squares horizontally, vertically, or diagonally.
 * </p>
 */
public class Queen extends ChessPiece {
    /**
     * Initializes a Queen with a specific position and color.
     *
     * @param row   the initial row index (0-7)
     * @param col   the initial column index (0-7)
     * @param color the color of the queen (WHITE or BLACK)
     * @throws IllegalArgumentException if the position is outside the 0-7 chessboard range
     */
    public Queen(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Validates if the Queen can move to the specified target.
     * A move is valid if the target is on the same row, same column,
     * or on a diagonal (where row displacement equals column displacement).
     *
     * @param row target row index
     * @param col target column index
     * @return true if the move is horizontal, vertical, or diagonal; false otherwise
     */
    @Override
    public boolean canMove(int row, int col) {
        // basic validation
        if (!isWithinBoard(row, col) || (row == this.row && col == this.col)) {
            return false;
        }

        //specific validation
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.col);
        return rowDiff == 0 || colDiff == 0 || rowDiff == colDiff;
    }
}
