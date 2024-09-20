package chess;

import java.util.ArrayList;

public class PawnMovesCalculator {
    private ChessPosition position;
    private int x;
    private int y;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ChessBoard board;

    public PawnMovesCalculator() {

    }

    /** This function checks for valid positions of the BISHOP piece
     *  It returns an array of valid positions
     */
    public void addValidMoves(ChessPosition endPosition) {
        ChessMove move = new ChessMove(position, endPosition, null);
        validMoves.add(move);
    }

    public ArrayList<ChessMove> checkMoves(ChessBoard chessBoard, ChessPosition pos) {
        position = pos;
        x = position.getRow();
        y = position.getColumn();
        board = chessBoard;

//        checkUpMoves();
//        checkDownMoves();

        return validMoves;
    }
}
