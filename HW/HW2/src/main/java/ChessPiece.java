/**
 * Abstract class representing a generic chess piece.
 * It implements the contract and handles shared state.
 */
public abstract class ChessPiece implements ChessPieceContract {
    //fields:
    //achieve both security(change from outside) and convenience(subclass can access easily)
    protected int row;
    protected int col;
    protected Color color;

    /**
     * Constructor for all chess pieces.
     * @throws IllegalArgumentException if coordinates are out of 0 - 7 bounds.
     */
    public ChessPiece(int row, int col, Color color) {
        // validate the initialization of a chess piece
        if (row > 7 || row < 0 || col > 7 || col < 0) {
            throw new IllegalArgumentException("Position out of bounds(0 - 7).");
        }
        //initialization of a chess piece
        this.row = row;
        this.col = col;
        this.color = color;
    }

    //getters
    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.col;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean canKill(ChessPiece piece) {
        return piece.getColor() != this.color && this.canMove(piece.getRow(), piece.getColumn());
    }

    /**
     * Check if a position is within the 8*8 board.
     */
    public boolean isWithinBoard(int r, int c) {
        return r >= 0 && r <= 7 && c >= 0 && c <= 7;
    }

}
