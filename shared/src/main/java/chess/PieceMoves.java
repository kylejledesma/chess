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
        checkMoves();
    }

    /** This function checks for valid positions of the KING piece
     *  It returns an array of valid positions
     */
    public void addValidMoves(ChessPosition endPosition) {
        ChessMove move = new ChessMove(position, endPosition, null);
        validMoves.add(move);
    }

    public ArrayList<ChessMove> checkMoves() {
        int x = position.getRow();
        int y = position.getColumn();

        // Up
        // Check Square R+1 of the Piece
        ChessPosition checkPositionUp = new ChessPosition(x+1, y);
        if (board.getPiece(checkPositionUp)==null) {
            addValidMoves(checkPositionUp);
        } else if (board.getPiece(checkPositionUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionUp);
        }

        // Up and Right
        // Check Square R+1, C+1 of the Piece
        ChessPosition checkPositionDRUp = new ChessPosition(x+1, y+1);
        if (board.getPiece(checkPositionDRUp)==null) {
            addValidMoves(checkPositionDRUp);
        } else if (board.getPiece(checkPositionDRUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionDRUp);
        }

        // Up and Left
        // Check Square R+1, C-1 of the Piece
        ChessPosition checkPositionDLUp = new ChessPosition(x+1, y-1);
        if (board.getPiece(checkPositionDLUp)==null) {
            addValidMoves(checkPositionDLUp);
        } else if (board.getPiece(checkPositionDLUp).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionDLUp);
        }

        // Right
        // Check Square C+1 of the Piece
        ChessPosition checkPositionRight = new ChessPosition(x, y+1);
        if (board.getPiece(checkPositionRight)==null) {
            addValidMoves(checkPositionRight);
        } else if (board.getPiece(checkPositionRight).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionRight);
        }

        // Left
        // Check Square C-1 of the Piece
        ChessPosition checkPositionLeft = new ChessPosition(x, y-1);
        if (board.getPiece(checkPositionLeft)==null) {
            addValidMoves(checkPositionLeft);
        } else if (board.getPiece(checkPositionLeft).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionLeft);
        }

        // Down
        // Check Square R-1 of the Piece
        ChessPosition checkPositionDown = new ChessPosition(x-1, y);
        if (board.getPiece(checkPositionDown)==null) {
            addValidMoves(checkPositionDown);
        } else if (board.getPiece(checkPositionDown).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionDown);
        }

        // Down and Right
        // Check Square R-1, C+1 of the Piece
        ChessPosition checkPositionDRDown = new ChessPosition(x-1, y+1);
        if (board.getPiece(checkPositionDRDown)==null) {
            addValidMoves(checkPositionDRDown);
        } else if (board.getPiece(checkPositionDRDown).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionDRDown);
        }

        // Down and Left
        // Check Square R-1, C-1 of the Piece
        ChessPosition checkPositionDLDown = new ChessPosition(x-1, y-1);
        if (board.getPiece(checkPositionDLDown)==null) {
            addValidMoves(checkPositionDLDown);
        } else if (board.getPiece(checkPositionDLDown).getTeamColor() == board.getPiece(position).getTeamColor()) {
            // return null;
        } else {
            addValidMoves(checkPositionDLDown);
        }

        return validMoves;
    }



    /*public checkValidMoves(ChessBoard board, ChessPosition position) {
        if(board[position.getRow()+1][position.getColumn()+1]==null){
            validMoves.add(position.getRow()+1, position.getColumn()+1);
        } else if(board[position.getRow()+1][position.getColumn()+1].isLowerCase()) {
            validMoves.add(position.getRow()+1, position.getColumn()+1);
        } else {
            return null;
        }
    }*/

    public ArrayList<ChessMove> getValidMoves() {
        //validMoves.add(position);
        return validMoves;
    }

}
