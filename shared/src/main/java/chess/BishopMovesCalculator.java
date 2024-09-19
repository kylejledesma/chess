package chess;

import java.util.ArrayList;

public class BishopMovesCalculator {

    private ChessPosition position;
    private int x;
    private int y;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ChessBoard board;

    public BishopMovesCalculator() {

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

        checkDiagonalUpRightMoves();
        checkDiagonalUpLeftMoves();
        checkDiagonalDownRightMoves();
        checkDiagonalDownLeftMoves();

//        // Up and Right
//        // Check Square R+1, C+1 of the Piece
//        while(x < 8 && y < 7 && board.getPiece(checkPositionDiagonalUpRight).getTeamColor() == board.getPiece(position).getTeamColor()){ // Allow move if not at the top rightmost position
//            ChessPosition checkPositionDRUp = new ChessPosition(x+1, y+1);
//            if (board.getPiece(checkPositionDRUp)==null) {
//                addValidMoves(checkPositionDRUp);
//            } else if (board.getPiece(checkPositionDRUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
//                // return null;
//            } else {
//                addValidMoves(checkPositionDRUp);
//            }
//        }

        return validMoves;
    }

    private void checkDiagonalUpRightMoves() {
        int a = x;
        int b = y;
        while(a<8 && b<8){
            a++;
            b++;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkDiagonalUpLeftMoves() {
        int a = x;
        int b = y;
        while(a<8 && b>0){
            a++;
            b--;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkDiagonalDownRightMoves() {
        int a = x;
        int b = y;
        while(a>0 && b<8){
            a--;
            b++;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkDiagonalDownLeftMoves() {
        int a = x;
        int b = y;
        while(a>1 && b>1){ // WHY???
            a--;
            b--;
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

}
