package chess;

import java.util.ArrayList;

public class PieceMoves {
    private ChessBoard myBoard;
    private ChessPosition myPosition;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();

    public PieceMoves() {

    }

    public ArrayList<ChessMove> checkPieceMoves(ChessBoard board, ChessPosition position){
        // Initialize values
        this.myBoard = board;
        this.myPosition = position;

        if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.KING){
            KingMovesCalculator checkMoves = new KingMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, position);
        } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.QUEEN){
            QueenMovesCalculator checkMoves = new QueenMovesCalculator();;
            validMoves = checkMoves.checkValidMoves(board, position);
        } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.ROOK) {
            RookMovesCalculator checkMoves = new RookMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, position);
        } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMovesCalculator checkMoves = new BishopMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, position);
        } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.KNIGHT) {
            KnightMovesCalculator checkMoves = new KnightMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, position);
        } else if (board.getPiece(position).getPieceType() == ChessPiece.PieceType.PAWN) {
            PawnMovesCalculator checkMoves = new PawnMovesCalculator();
            validMoves = checkMoves.checkValidMoves(board, position);
        } else throw new RuntimeException("Invalid piece type");

        return validMoves;
    }
}
