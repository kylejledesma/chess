package chess;

import java.util.ArrayList;

public class PieceMoves {

    private ChessBoard board;
    private ChessPosition position;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    //private ChessPosition checkPosition;

    public PieceMoves(ChessBoard board, ChessPosition position) {
        this.board = board;
        this.position = position;
        calculatePieceType();
        // checkMoves();
    }

    private void calculatePieceType(){
        ChessPiece.PieceType pieceType = board.getPiece(position).getPieceType();
        if (pieceType == ChessPiece.PieceType.KING) {
            KingMovesCalculator calculator = new KingMovesCalculator();
            validMoves = calculator.checkMoves(board, position);
        } else if (pieceType == ChessPiece.PieceType.BISHOP) {
            BishopMovesCalculator calculator = new BishopMovesCalculator();
            validMoves = calculator.checkMoves(board, position);
        } else if (pieceType == ChessPiece.PieceType.ROOK) {
            RookMovesCalculator calculator = new RookMovesCalculator();
            validMoves = calculator.checkMoves(board, position);
        } else if (pieceType == ChessPiece.PieceType.QUEEN) {
            QueenMovesCalculator calculator = new QueenMovesCalculator();
            validMoves = calculator.checkMoves(board, position);
        } else if (pieceType == ChessPiece.PieceType.KNIGHT) {
            KnightMovesCalculator calculator = new KnightMovesCalculator();
            validMoves = calculator.checkMoves(board, position);
        } else if (pieceType == ChessPiece.PieceType.PAWN) {
            PawnMovesCalculator calculator = new PawnMovesCalculator();
            validMoves = calculator.checkMoves(board, position);
        }
    }

    public ArrayList<ChessMove> getValidMoves() {
        return validMoves;
    }

}
