package chess;

import java.util.ArrayList;

public class RookMovesCalculator {
    private ChessPosition position;
    private int x;
    private int y;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ChessBoard board;

    public RookMovesCalculator() {

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

        checkRightMoves();
        checkLeftMoves();
        checkDownMoves();
        checkUpMoves();

        return validMoves;
    }

    private void checkRightMoves() {
        int a = x;
        int b = y;
        while(b<8){
            b++;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
                break; // Break so that once you hit an opposing piece, you don't keep calculating the squares behind it
            } else {
                break;
            }
        }
    }

    private void checkLeftMoves() {
        int a = x;
        int b = y;
        while(b>1){
            b--;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
                break; // Break so that once you hit an opposing piece, you don't keep calculating the squares behind it
            } else {
                break;
            }
        }
    }

    private void checkDownMoves() {
        int a = x;
        int b = y;
        while(a>1){
            a--;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
                break; // Break so that once you hit an opposing piece, you don't keep calculating the squares behind it
            } else {
                break;
            }
        }
    }

    private void checkUpMoves() {
        int a = x;
        int b = y;
        while(a<8){
            a++;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
                break; // Break so that once you hit an opposing piece, you don't keep calculating the squares behind it
            } else {
                break;
            }
        }
    }
}
