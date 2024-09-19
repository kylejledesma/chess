package chess;

import java.util.ArrayList;

public class KingMovesCalculator {

    private ChessPosition position;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    public KingMovesCalculator() {

    }

    /** This function checks for valid positions of the KING piece
     *  It returns an array of valid positions
     */
    public void addValidMoves(ChessPosition endPosition) {
        ChessMove move = new ChessMove(position, endPosition, null);
        validMoves.add(move);
    }

    public ArrayList<ChessMove> checkMoves(ChessBoard board, ChessPosition pos) {
        position = pos;
        int x = position.getRow();
        int y = position.getColumn();

        // Up
        // Check Square R+1 of the Piece
        ChessPosition checkPositionUp = new ChessPosition(x+1, y);
        if(x < 8){  // Allow move if not at the top row
            if (board.getPiece(checkPositionUp)==null) {
                 addValidMoves(checkPositionUp);
            } else if (board.getPiece(checkPositionUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionUp);
            }
        }

        // Up and Right
        // Check Square R+1, C+1 of the Piece
        if(x < 8 && y < 7){ // Allow move if not at the top rightmost position
            ChessPosition checkPositionDRUp = new ChessPosition(x+1, y+1);
            if (board.getPiece(checkPositionDRUp)==null) {
                addValidMoves(checkPositionDRUp);
            } else if (board.getPiece(checkPositionDRUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionDRUp);
            }
        }

        // Up and Left
        // Check Square R+1, C-1 of the Piece
        if(x<8 && y>1){ // Allow if not in the top leftmost column
            ChessPosition checkPositionDLUp = new ChessPosition(x+1, y-1);
            if (board.getPiece(checkPositionDLUp)==null) {
                addValidMoves(checkPositionDLUp);
            } else if (board.getPiece(checkPositionDLUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionDLUp);
            }
        }

        // Right
        // Check Square C+1 of the Piece
        if(y<8){ // Allow if not in the rightmost column
            ChessPosition checkPositionRight = new ChessPosition(x, y+1);
            if (board.getPiece(checkPositionRight)==null) {
                addValidMoves(checkPositionRight);
            } else if (board.getPiece(checkPositionRight).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionRight);
            }
        }

        // Left
        // Check Square C-1 of the Piece
        if(y>1){ // Allow if not in the leftmost column
            ChessPosition checkPositionLeft = new ChessPosition(x, y-1);
            if (board.getPiece(checkPositionLeft)==null) {
                addValidMoves(checkPositionLeft);
            } else if (board.getPiece(checkPositionLeft).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionLeft);
            }
        }

        // Down
        // Check Square R-1 of the Piece
        if(x>1){ // Allow if not in the bottom row
            ChessPosition checkPositionDown = new ChessPosition(x-1, y);
            if (board.getPiece(checkPositionDown)==null) {
                addValidMoves(checkPositionDown);
            } else if (board.getPiece(checkPositionDown).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionDown);
            }
        }

        // Down and Right
        // Check Square R-1, C+1 of the Piece
        if(x>1 && y<8){ // Allow if not in the bottom rightmost position
            ChessPosition checkPositionDRDown = new ChessPosition(x-1, y+1);
            if (board.getPiece(checkPositionDRDown)==null) {
                addValidMoves(checkPositionDRDown);
            } else if (board.getPiece(checkPositionDRDown).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionDRDown);
            }
        }

        // Down and Left
        // Check Square R-1, C-1 of the Piece
        if(x>1 && y>1){ // Allow move if not in the bottom leftmost position
            ChessPosition checkPositionDLDown = new ChessPosition(x-1, y-1);
            if (board.getPiece(checkPositionDLDown)==null) {
                addValidMoves(checkPositionDLDown);
            } else if (board.getPiece(checkPositionDLDown).getTeamColor() == board.getPiece(position).getTeamColor()) {
                // return null;
            } else {
                addValidMoves(checkPositionDLDown);
            }
        }

        return validMoves;
    }

}
