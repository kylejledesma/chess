package chess;

import java.util.ArrayList;

public class PieceMoves {

    private final ChessBoard board;
    private final ChessPosition position;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();

    public PieceMoves(ChessBoard board, ChessPosition position) {
        this.board = board;
        this.position = position;
    }

    /** This function checks for valid positions of the KING piece
     *  It returns an array of valid positions
     */

    /*public checkValidMoves(ChessBoard board, ChessPosition position) {
        if(board[position.getRow()+1][position.getColumn()+1]==null){
            validMoves.add(position.getRow()+1, position.getColumn()+1);
        } else if(board[position.getRow()+1][position.getColumn()+1].isLowerCase()) {
            validMoves.add(position.getRow()+1, position.getColumn()+1);
        } else {
            return null;
        }
    }*/

    public ArrayList getValidMoves() {
        //validMoves.add(position);
        return validMoves;
    }

}
