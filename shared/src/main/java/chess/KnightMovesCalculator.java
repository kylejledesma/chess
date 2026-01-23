package chess;

import java.util.ArrayList;

public class KnightMovesCalculator {

    private ChessBoard myBoard;
    private ChessPosition startPosition;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private int x;
    private int y;

    KnightMovesCalculator() {

    }

    public ArrayList<ChessMove> checkValidMoves(ChessBoard board, ChessPosition position) {
        this.myBoard = board;
        this.startPosition = position;
        this.x = position.getRow();
        this.y = position.getColumn();

        checkUpLeft();
        checkUpRight();
        checkRightUp();
        checkRightDown();
        checkLeftUp();
        checkLeftDown();
        checkDownLeft();
        checkDownRight();

        return validMoves;
    }

    private void checkUpLeft() {
        int a = x + 2;
        int b = y - 1;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkUpRight() {
        int a = x + 2;
        int b = y + 1;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkRightUp() {
        int a = x + 1;
        int b = y + 2;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkRightDown() {
        int a = x - 1;
        int b = y + 2;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkLeftUp() {
        int a = x + 1;
        int b = y - 2;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkLeftDown() {
        int a = x - 1;
        int b = y - 2;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkDownLeft() {
        int a = x - 2;
        int b = y - 1;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }

    private void checkDownRight() {
        int a = x - 2;
        int b = y + 1;
        if (a > 0 && a < 9 && b > 0 && b < 9) {
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (myBoard.getPiece(checkPosition) == null) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            } else if (myBoard.getPiece(checkPosition).getTeamColor() != myBoard.getPiece(startPosition).getTeamColor()) {
                validMoves.add(new ChessMove(startPosition, checkPosition, null));
            }
        }
    }
}