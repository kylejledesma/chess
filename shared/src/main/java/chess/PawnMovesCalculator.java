package chess;

import java.util.ArrayList;

public class PawnMovesCalculator {
    private ChessBoard myBoard;
    private ChessPosition startPosition;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private int x;
    private int y;
    private String team;

    PawnMovesCalculator(){

    }

    public ArrayList<ChessMove> checkValidMoves(ChessBoard board, ChessPosition position){
        // Initialize values
        this.myBoard = board;
        this.startPosition = position;
        this.x = position.getRow();
        this.y = position.getColumn();
        this.team = board.getPiece(position).getTeamColor().toString();

        if (team.equals("WHITE")){
            checkUp();
        } else if (team.equals("BLACK")) {
            checkDown();
        }

        return validMoves;
    }

    /**
     * Calculates Up Moves for White Piece
     */
    private void checkUp(){

        // Condition Check: Still has a row ahead
        if (x < 8) {
            ChessPosition checkPositionUp = new ChessPosition(x + 1, y);
            if (myBoard.getPiece(checkPositionUp) == null) {
                validMoves.add(new ChessMove(startPosition, checkPositionUp, null));
                if (x == 2) {
                    ChessPosition checkPosition2Up = new ChessPosition(x + 2, y);
                    if (myBoard.getPiece(checkPosition2Up) == null) {
                        validMoves.add(new ChessMove(startPosition, checkPosition2Up, null));
                    }
                }
            }

            // Check Diagonal Left. Condition Check: Still has a column to the left
            if (y > 1) {
                ChessPosition checkPositionDL = new ChessPosition(x + 1, y - 1);
                if (myBoard.getPiece(checkPositionDL) == null) {
                } else if (!myBoard.getPiece(checkPositionDL).getTeamColor().toString().equals(team)) {
                    validMoves.add(new ChessMove(startPosition, checkPositionDL, null));
                }
            }

            // Check Diagonal Right. Condition Check: Still has a column to the right
            if (y < 8) {
                ChessPosition checkPositionDR = new ChessPosition(x + 1, y + 1);
                if (myBoard.getPiece(checkPositionDR) == null) {
                } else if (!myBoard.getPiece(checkPositionDR).getTeamColor().toString().equals(team)) {
                    validMoves.add(new ChessMove(startPosition, checkPositionDR, null));
                }
            }
        }

        // Check for Promotion
        int i = 0;
        int s = validMoves.size();
        while (i < s) {
            if (validMoves.get(i).getEndPosition().getRow() == 8) {
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.QUEEN));
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.ROOK));
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.BISHOP));
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.KNIGHT));
            }
            i++;
        }

        // Remove empty ChessMove at Row 8 without PromoPieceType
        i = 0;
        while (i < s) {
            if (validMoves.get(i).getEndPosition().getRow() == 8 && validMoves.get(i).getPromotionPiece() == null) {
                validMoves.remove(i);
            } else i++;
        }

    }

    /**
     * Calculates Downward Moves for Black Piece
     */
    private void checkDown() {
        // Condition Check: Still has a row below
        if (x > 1) {
            ChessPosition checkPositionUp = new ChessPosition(x - 1, y);
            if (myBoard.getPiece(checkPositionUp) == null) {
                validMoves.add(new ChessMove(startPosition, checkPositionUp, null));
                if (x == 7) {
                    ChessPosition checkPosition2Up = new ChessPosition(x - 2, y);
                    if (myBoard.getPiece(checkPosition2Up) == null) {
                        validMoves.add(new ChessMove(startPosition, checkPosition2Up, null));
                    }
                }
            }

            // Check Diagonal Left. Condition Check: Still has a column to the left
            if (y > 1) {
                ChessPosition checkPositionDL = new ChessPosition(x - 1, y - 1);
                if (myBoard.getPiece(checkPositionDL) == null) {
                } else if (!myBoard.getPiece(checkPositionDL).getTeamColor().toString().equals(team)) {
                    validMoves.add(new ChessMove(startPosition, checkPositionDL, null));
                }
            }

            // Check Diagonal Right. Condition Check: Still has a column to the right
            if (y < 8) {
                ChessPosition checkPositionDR = new ChessPosition(x - 1, y + 1);
                if (myBoard.getPiece(checkPositionDR) == null) {
                } else if (!myBoard.getPiece(checkPositionDR).getTeamColor().toString().equals(team)) {
                    validMoves.add(new ChessMove(startPosition, checkPositionDR, null));
                }
            }
        }

        // Check for Promotion
        int i = 0;
        int s = validMoves.size();
        while (i < s) {
            if (validMoves.get(i).getEndPosition().getRow() == 1) {
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.QUEEN));
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.ROOK));
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.BISHOP));
                validMoves.add(new ChessMove(startPosition, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.KNIGHT));
            }
            i++;
        }

        // Remove empty ChessMove at Row 8 without PromoPieceType
        i = 0;
        while (i < s) {
            if (validMoves.get(i).getEndPosition().getRow() == 1 && validMoves.get(i).getPromotionPiece() == null) {
                validMoves.remove(i);
            } else i++;
        }
    }
}
