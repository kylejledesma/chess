package chess;

import java.util.ArrayList;
import java.util.Arrays;

public class KingMovesCalculator {

    private ChessBoard myBoard;
    private ChessPosition startPosition;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private int x;
    private int y;

    KingMovesCalculator() {

    }

    public ArrayList<ChessMove> checkValidMoves(ChessBoard board, ChessPosition position) {
        this.myBoard = board;
        this.startPosition = position;
        this.x = position.getRow();
        this.y = position.getColumn();

        checkUp();
        checkDown();
        checkLeft();
        checkRight();
        checkUpLeft();
        checkUpRight();
        checkDownLeft();
        checkDownRight();

        return validMoves;
    }

    private void checkUp() {
        if ( x < 8 ) {
            ChessPosition checkPosition = new ChessPosition(x + 1, y );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkDown() {
        if ( x > 1 ) {
            ChessPosition checkPosition = new ChessPosition(x - 1, y );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkLeft() {
        if ( y > 1 ) {
            ChessPosition checkPosition = new ChessPosition( x, y - 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkRight() {
        if ( y < 8 ) {
            ChessPosition checkPosition = new ChessPosition( x, y + 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkUpLeft() {
        if ( x < 8 && y > 1 ) {
            ChessPosition checkPosition = new ChessPosition( x + 1, y - 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }
    private void checkUpRight() {
        if ( x < 8 && y < 8 ) {
            ChessPosition checkPosition = new ChessPosition( x + 1, y + 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkDownLeft() {
        if ( x > 1 && y > 1 ) {
            ChessPosition checkPosition = new ChessPosition( x - 1, y - 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkDownRight() {
        if ( x > 1 && y < 8 ) {
            ChessPosition checkPosition = new ChessPosition( x - 1, y + 1 );
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }
}
