/**
 * Represents a Bishop chess piece.
 * The Bishop moves any number of squares diagonally.
 * <p>
 * A diagonal move is characterized by the absolute change in row
 * being equal to the absolute change in column.
 * </p>
 */
public class Bishop extends ChessPiece {
    /**
     * Initializes a Bishop with a specific position and color.
     *
     * @param row   the initial row index (0-7)
     * @param col   the initial column index (0-7)
     * @param color the color of the bishop (WHITE or BLACK)
     * @throws IllegalArgumentException if the position is outside the 0-7 chessboard range
     */
    public Bishop(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Validates if the Bishop can move to the specified target coordinates.
     * A move is valid if the absolute difference between the target row and current row
     * is equal to the absolute difference between the target column and current column.
     *
     * @param row target row index
     * @param col target column index
     * @return true if the move is diagonal and within board boundaries, false otherwise
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
        return rowDiff == colDiff;
    }
}
