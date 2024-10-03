package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return this.pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return this.type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        if (board.getPiece(myPosition).getPieceType() == ChessPiece.PieceType.KING){
            KingMovesCalculator checkMoves = new KingMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, myPosition);
        } else if (board.getPiece(myPosition).getPieceType() == ChessPiece.PieceType.QUEEN){
            QueenMovesCalculator checkMoves = new QueenMovesCalculator();;
            validMoves = checkMoves.checkValidMoves(board, myPosition);
        } else if (board.getPiece(myPosition).getPieceType() == ChessPiece.PieceType.ROOK) {
            RookMovesCalculator checkMoves = new RookMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, myPosition);
        } else if (board.getPiece(myPosition).getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMovesCalculator checkMoves = new BishopMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, myPosition);
        } else if (board.getPiece(myPosition).getPieceType() == ChessPiece.PieceType.KNIGHT) {
            KnightMovesCalculator checkMoves = new KnightMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, myPosition);
        } else if (board.getPiece(myPosition).getPieceType() == ChessPiece.PieceType.PAWN) {
            PawnMovesCalculator checkMoves = new PawnMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, myPosition);
        } else throw new RuntimeException("Invalid piece type");

        return validMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type && Objects.equals(validMoves, that.validMoves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type, validMoves);
    }
}
