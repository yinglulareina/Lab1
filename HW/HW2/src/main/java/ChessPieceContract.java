/**
 * Interface defining the essential behaviors of any chess piece.
 */
public interface ChessPieceContract {
    /**
     * @return current row (0 - 7)
     */
    int getRow();

    /**
     * @return current col(0 - 7)
     */
    int getColumn();

    /**
     * @return the color of the piece
     */
    Color getColor();

    /**
     * @param row target row
     * @param col target col
     * @return true if the chess piece can move to the target position
     */
    boolean canMove(int row, int col);

    /**
     * @param piece target piece to capture
     * @return true if the chess piece can capture the target piece
     */
    boolean canKill(ChessPiece piece);

}