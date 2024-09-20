package chess;

import java.util.ArrayList;

public class KnightMovesCalculator {

    private ChessPosition position;
    private int x;
    private int y;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ChessBoard board;

    public KnightMovesCalculator() {

    }

    /** This function checks for valid positions of the piece
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

        checkUpRightMove();
        checkUpLeftMove();
        checkLeftUpMove();
        checkLeftDownMove();
        checkRightUpMove();
        checkRightDownMove();
        checkDownLeftMove();
        checkDownRightMove();

        return validMoves;
    }

    private void checkUpRightMove() {
        int a = x + 2;
        int b = y + 1;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkUpLeftMove() {
        int a = x + 2;
        int b = y - 1;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkLeftUpMove() {
        int a = x + 1;
        int b = y - 2;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkLeftDownMove() {
        int a = x - 1;
        int b = y - 2;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkRightUpMove() {
        int a = x + 1;
        int b = y + 2;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkRightDownMove() {
        int a = x - 1;
        int b = y + 2;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkDownLeftMove() {
        int a = x - 2;
        int b = y - 1;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }

    private void checkDownRightMove() {
        int a = x - 2;
        int b = y + 1;
        if((a>0 && a<9) && (b>0 && b<9)){
            ChessPosition checkPosition = new ChessPosition(a, b);
            if (board.getPiece(checkPosition)==null) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            } else if (board.getPiece(checkPosition).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPosition, null));
            }
        }
    }
}
