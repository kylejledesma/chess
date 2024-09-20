package chess;

import java.util.ArrayList;

public class PawnMovesCalculator {
    private ChessPosition position;
    private int x;
    private int y;
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ChessBoard board;
    private String team;

    public PawnMovesCalculator() {

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
        team = chessBoard.getPiece(pos).getTeamColor().toString().toLowerCase();

        // Checks Team. Runs Pawn Code based on which team Piece belongs to
        if (team.equals("white")) {
            checkUpMoves();
        }else if (team.equals("black")) {
            checkDownMoves();
        }

        return validMoves;
    }

    /**
     * Calculates the possible moves for White Pawns
     */
    private void checkUpMoves() {
        int a = x;
        int b = y;

        // Check a space ahead
        if(a<8){
            ChessPosition checkPositionUp = new ChessPosition(a+1, b);

            if (board.getPiece(checkPositionUp)==null) {

                validMoves.add(new ChessMove(position, checkPositionUp, null));

                // Only if there is empty square ahead does it check 2 spaces ahead if on start line
                if(a==2){
                    ChessPosition checkPosition2Up = new ChessPosition(a+2, b);
                    if (board.getPiece(checkPosition2Up)==null) {
                        validMoves.add(new ChessMove(position, checkPosition2Up, null));
                    }
                }
            }
        }

        // Check up and left. Valid if opposing piece present
        if(a<8 && b>1){
            ChessPosition checkPositionDLUp = new ChessPosition(a+1, b-1);
            if (board.getPiece(checkPositionDLUp)==null) {

            } else if (board.getPiece(checkPositionDLUp).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPositionDLUp, null));
            }
        }

        // Check up and right. Valid if opposing piece present
        if(a<8 && b<8){
            ChessPosition checkPositionDRUp = new ChessPosition(a+1, b+1);
            if (board.getPiece(checkPositionDRUp)==null) {

            } else if (board.getPiece(checkPositionDRUp).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPositionDRUp, null));
            }
        }

        // Scans through the validMoves array for any instance of a Pawn arriving at the end, thus qualifying for promotion
        int i = 0;
        int s = validMoves.size();
        while(i < s){
            if(validMoves.get(i).getEndPosition().getRow() == 8 && validMoves.get(i).getPromotionPiece() == null){
                ChessMove toInsertQueen = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.QUEEN);
                ChessMove toInsertRook = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.ROOK);
                ChessMove toInsertBishop = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.BISHOP);
                ChessMove toInsertKnight = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.KNIGHT);
                validMoves.add(toInsertQueen);
                validMoves.add(toInsertRook);
                validMoves.add(toInsertBishop);
                validMoves.add(toInsertKnight);
            }
            i++;
        }

        // Scans through the validMoves array for any instance of a Pawn at end line but no promotion piece data. Removes it.
        i = 0;
        //s = validMoves.size();
        while(i < validMoves.size()){
            if (validMoves.get(i).getEndPosition().getRow() == 8 && validMoves.get(i).getPromotionPiece() == null){
                validMoves.remove(i);
            }else i++;
        }
    }

    /**
     * Calculates the possible moves for Black Pawns
     */
    private void checkDownMoves() {
        int a = x;
        int b = y;

        // Check a space below
        if(a>1){
            ChessPosition checkPositionUp = new ChessPosition(a-1, b);
            if (board.getPiece(checkPositionUp)==null) {

                validMoves.add(new ChessMove(position, checkPositionUp, null));

                // Only when vacant square ahead does it check 2 spaces ahead if on start line
                if(a==7){
                    ChessPosition checkPosition2Up = new ChessPosition(a-2, b);
                    if (board.getPiece(checkPosition2Up)==null) {
                        validMoves.add(new ChessMove(position, checkPosition2Up, null));
                    }
                }
            }
        }

        // Check down and left. Valid if opposing piece present
        if(a>1 && b>1){
            ChessPosition checkPositionDLUp = new ChessPosition(a-1, b-1);
            if (board.getPiece(checkPositionDLUp)==null) {

            } else if (board.getPiece(checkPositionDLUp).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPositionDLUp, null));
            }
        }

        // Check down and right. Valid if opposing piece present
        if(a>1 && b<8){
            ChessPosition checkPositionDRUp = new ChessPosition(a-1, b+1);
            if (board.getPiece(checkPositionDRUp)==null) {

            } else if (board.getPiece(checkPositionDRUp).getTeamColor() != board.getPiece(position).getTeamColor()) {
                validMoves.add(new ChessMove(position, checkPositionDRUp, null));
            }
        }

        // Scans through the validMoves array for any instance of a Pawn arriving at the end, thus qualifying for promotion
        int i = 0;
        int s = validMoves.size();
        while(i < s){
            if(validMoves.get(i).getEndPosition().getRow() == 1 && validMoves.get(i).getPromotionPiece() == null){
                ChessMove toInsertQueen = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.QUEEN);
                ChessMove toInsertRook = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.ROOK);
                ChessMove toInsertBishop = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.BISHOP);
                ChessMove toInsertKnight = new ChessMove(position, validMoves.get(i).getEndPosition(), ChessPiece.PieceType.KNIGHT);
                validMoves.add(toInsertQueen);
                validMoves.add(toInsertRook);
                validMoves.add(toInsertBishop);
                validMoves.add(toInsertKnight);
            }
            i++;
        }

        // Scans through the validMoves array for any instance of a Pawn at end line but no promotion piece data. Removes it.
        i = 0;
        while(i < validMoves.size()){
            if (validMoves.get(i).getEndPosition().getRow() == 1 && validMoves.get(i).getPromotionPiece() == null){
                validMoves.remove(i);
            }else i++;
        }
    }
}
