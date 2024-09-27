package chess;

import java.util.ArrayList;

public class BishopMovesCalculator {
    private ChessBoard myBoard;
    private ChessPosition startPosition;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private int x;
    private int y;

    BishopMovesCalculator(){

    }

    public ArrayList<ChessMove> checkValidMoves(ChessBoard board, ChessPosition position){
        this.myBoard = board;
        this.startPosition = position;
        this.x = position.getRow();
        this.y = position.getColumn();

        checkUpLeft();
        checkUpRight();
        checkDownLeft();
        checkDownRight();

        return validMoves;
    }

    private void checkUpLeft(){
        this.x = startPosition.getRow();
        this.y = startPosition.getColumn();
        while (x < 8 && y > 1) {
            ChessPosition checkPosition = new ChessPosition(x + 1, y - 1);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                x++;
                y--;
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                break;
            } else break;
        }
    }

    private void checkUpRight(){
        this.x = startPosition.getRow();
        this.y = startPosition.getColumn();
        while (x < 8 && y < 8) {
            ChessPosition checkPosition = new ChessPosition(x + 1, y + 1);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                x++;
                y++;
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                break;
            } else break;
        }
    }

    private void checkDownLeft(){
        this.x = startPosition.getRow();
        this.y = startPosition.getColumn();
        while (x > 1 && y > 1) {
            ChessPosition checkPosition = new ChessPosition(x - 1, y - 1);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                x--;
                y--;
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                break;
            } else break;
        }
    }

    private void checkDownRight(){
        this.x = startPosition.getRow();
        this.y = startPosition.getColumn();
        while (x > 1 && y < 8) {
            ChessPosition checkPosition = new ChessPosition(x - 1, y + 1);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                x--;
                y++;
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
                break;
            } else break;
        }
    }
}
