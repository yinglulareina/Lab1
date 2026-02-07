/**
 * Represents a Pawn chess piece.
 * The Pawn has unique movement rules:
 * <ul>
 * <li>Moves forward one square.</li>
 * <li>Can move forward two squares from its initial starting row.</li>
 * <li>Captures diagonally forward one square.</li>
 * <li>Cannot move or capture backwards.</li>
 * </ul>
 */
public class Pawn extends ChessPiece {
    /**
     * Constructs a Pawn piece and validates its starting position.
     * White pawns cannot start on row 0, and black pawns cannot start on row 7,
     * as these are promotion zones or impossible starting points.
     *
     * @param row   the initial row (1-6)
     * @param col   the initial column (1-6)
     * @param color the color of the piece
     * @throws IllegalArgumentException if position is out of bounds or in a restricted row
     */
    public Pawn(int row, int col, Color color) {
        // call the method from parent class to validate
        super(row, col, color);
        // special validation for Pawn
        if (row == 0 && color == Color.WHITE) {
            throw new IllegalArgumentException("White Pawn can not start in row 0.");
        }
        if (row == 7 && color == Color.BLACK) {
            throw new IllegalArgumentException("Black Pawn can not start in row 7.");
        }

    }

    /**
     * Determines if the pawn can move to the target coordinates.
     * Note: This only handles movement. For capturing, use {@link #canKill(ChessPiece)}.
     *
     * @param row target row
     * @param col target column
     * @return true if the move is a valid forward step or double-step from the start
     */
    @Override
    public boolean canMove(int row, int col) {
        // basic validation
        if (!isWithinBoard(row, col) || (row == this.row && col == this.col)) {
            return false;
        }

        // specific validation for Pawn: forward only. two for first move. one for the rest case.
        if (col != this.col) {
            return false;
        }
        int rowDiff = row - this.row;
        if (this.color == Color.WHITE) {
            if (this.row == 1) {
                return rowDiff == 1 || rowDiff == 2;
            } else {
                return rowDiff == 1;
            }
        } else {
            if (this.row == 6) {
                return rowDiff == -1 || rowDiff == -2;
            } else {
                return rowDiff == -1;
            }
        }
    }

    /**
     * Determines if the pawn can capture the given piece.
     * Pawns capture specifically one square diagonally forward.
     *
     * @param piece the opponent's piece to potentially capture
     * @return true if the piece is of a different color and located one square diagonally forward
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        // can not kill friends(same color)
        if (piece.getColor() == this.color) {
            return false;
        }

        // can only kill the one gird diagonally forward
        int rowDiff = piece.getRow() - this.row;
        int colDiff = Math.abs(piece.getColumn() - this.col);
        if (this.color == Color.WHITE) {
            return rowDiff == 1 && colDiff == 1;
        } else {
            return rowDiff == -1 && colDiff == 1;
            }
        }
}
