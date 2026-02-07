/**
 * Represents a Rook chess piece.
 * The Rook moves any number of squares horizontally or vertically.
 * <p>
 * In chess terminology, it moves along the ranks (rows) and files (columns)
 * of the board. It is one of the "major pieces."
 * </p>
 */
public class Rook extends ChessPiece {
    /**
     * Initializes a Rook with a specific position and color.
     *
     * @param row   the initial row index (0-7)
     * @param col   the initial column index (0-7)
     * @param color the color of the rook (WHITE or BLACK)
     * @throws IllegalArgumentException if the position is outside the 0-7 chessboard range
     */
    public Rook(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Validates if the Rook can move to the specified target coordinates.
     * A move is valid if either the row or the column remains the same as
     * the current position, excluding the current square itself.
     *
     * @param row target row index
     * @param col target column index
     * @return true if the move is strictly horizontal or vertical, false otherwise
     */
    @Override
    public boolean canMove(int row, int col) {
        //basic validation
        if (!isWithinBoard(row, col) || (row == this.row && col == this.col)) {
            return false;
        }

        // specific validation
        int rowDiff = Math.abs(row - this.row);
        int colDiff = Math.abs(col - this.col);
        return rowDiff == 0 || colDiff == 0;
    }
}
