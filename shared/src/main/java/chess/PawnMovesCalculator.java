package chess;

import java.util.ArrayList;

public class PawnMovesCalculator {

    private ChessBoard myBoard;
    private ChessPosition startPosition;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ChessGame.TeamColor teamColor;
    private int x;
    private int y;
    private int forward;

    PawnMovesCalculator() {

    }

    public ArrayList<ChessMove> checkValidMoves(ChessBoard board, ChessPosition position) {
        this.myBoard = board;
        this.startPosition = position;
        this.x = position.getRow();
        this.y = position.getColumn();
        this.teamColor = board.getPiece(position).getTeamColor();

        setForward();
        checkForward();
        checkForwardLeft();
        checkForwardRight();

        return validMoves;
    }

    private void setForward() {
        if (teamColor == ChessGame.TeamColor.WHITE) this.forward = 1; else if (teamColor == ChessGame.TeamColor.BLACK)
            this.forward = -1;
    }

    private void checkForward() {
        if ( x > 1 && x < 8 ) {
            ChessPosition checkPosition = new ChessPosition(x + forward, y );
            if (myBoard.getPiece(checkPosition) == null) {
                if (checkPosition.getRow() == 8 || checkPosition.getRow() == 1) {
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.QUEEN));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.ROOK));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.KNIGHT));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.BISHOP));
                    return;
                } else if (startPosition.getRow() == 2 || startPosition.getRow() == 7) {
                    ChessPosition checkTwoPosition = new ChessPosition( x + (2 * forward), y);
                    if (myBoard.getPiece(checkTwoPosition) == null) {
                        validMoves.add(new ChessMove(startPosition, checkTwoPosition, null));
                    }
                }
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }

    }

    private void checkForwardLeft() {
        if ( x > 1 && x < 8 && y > 1 ) {
            ChessPosition checkPosition = new ChessPosition(x + forward, y - 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                return;
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != teamColor) {
                if (checkPosition.getRow() == 8 || checkPosition.getRow() == 1) {
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.QUEEN));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.ROOK));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.KNIGHT));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.BISHOP));
                } else {
                    validMoves.add(new ChessMove(startPosition, checkPosition, null));
                }
            }
        }
    }

    private void checkForwardRight() {
        if ( x > 1 && x < 8 && y < 8 ) {
            ChessPosition checkPosition = new ChessPosition(x + forward, y + 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                return;
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != teamColor) {
                if (checkPosition.getRow() == 8 || checkPosition.getRow() == 1) {
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.QUEEN));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.ROOK));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.KNIGHT));
                    validMoves.add(new ChessMove(startPosition, checkPosition, ChessPiece.PieceType.BISHOP));
                } else {
                    validMoves.add(new ChessMove(startPosition, checkPosition, null));
                }
            }
        }
    }
}
