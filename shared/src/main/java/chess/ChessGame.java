package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    private TeamColor teamTurn;
    private ChessBoard chessBoard = new ChessBoard();
    private ArrayList<ChessMove> validMoves = new ArrayList<>();
    private ArrayList<ChessMove> opponentMoves = new ArrayList<>();

    ArrayList<ChessPosition> endPositions = new ArrayList<>(); // Test use

    public ChessGame() {
        // 1. Set chessBoard to default 2. Set teamTurn to WHITE
        chessBoard.resetBoard();
        setTeamTurn(TeamColor.WHITE );
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return this.teamTurn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        this.teamTurn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        //ChessBoard cloneBoard = this.chessBoard;
        return null;
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
       ChessPiece piece = this.chessBoard.getPiece(move.getStartPosition());
       this.chessBoard.addPiece(move.getEndPosition(), piece);
       setSquareNull(move.getStartPosition());
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        ChessPosition kingPosition = new ChessPosition(0,0);

        if (teamColor == TeamColor.WHITE) {

            // Scans for all the end positions of opposing team
            for (int i = 0; i < chessBoard.getBoard().length; i++) {
                for (int j = 0; j < chessBoard.getBoard()[i].length; j++) {
                    if (chessBoard.getBoard()[i][j] == null) {

                    } else if (chessBoard.getBoard()[i][j].getTeamColor() == teamColor && chessBoard.getBoard()[i][j].getPieceType()
                            == ChessPiece.PieceType.KING) {
                        kingPosition = new ChessPosition(i+1, j+1); // Remember to increment values of i and j because notation format is different for array and the row and column values
                    } else if (chessBoard.getBoard()[i][j].getTeamColor() != teamColor) {
                        Collection<ChessMove> oppMoves = new ArrayList<>();
                        oppMoves = chessBoard.getBoard()[i][j].pieceMoves(chessBoard, new ChessPosition(i+1, j+1));
                        opponentMoves.addAll(oppMoves);
                    }
                }
            }

            // Scans for King's Position among End Positions of opposing team
            for (ChessMove move : opponentMoves) {
                endPositions.add(move.getEndPosition());
                if (move.getEndPosition().equals(kingPosition)) {
                    return true;
                }
            }

        } else if (teamColor == TeamColor.BLACK) {

            // Scans for all the end positions of opposing team
            for (int i = 0; i < chessBoard.getBoard().length; i++) {
                for (int j = 0; j < chessBoard.getBoard()[i].length; j++) {
                    if (chessBoard.getBoard()[i][j] == null) {

                    } else if (chessBoard.getBoard()[i][j].getTeamColor() == teamColor && chessBoard.getBoard()[i][j].getPieceType()
                            == ChessPiece.PieceType.KING) {
                        kingPosition = new ChessPosition(i+1, j+1); // Remember to increment values of i and j because notation format is different for array and the row and column values
                    } else if (chessBoard.getBoard()[i][j].getTeamColor() != teamColor) {
                        Collection<ChessMove> oppMoves = new ArrayList<>();
                        oppMoves = chessBoard.getBoard()[i][j].pieceMoves(chessBoard, new ChessPosition(i+1, j+1));
                        opponentMoves.addAll(oppMoves);
                    }
                }
            }

            // Scans for King's Position among End Positions of opposing team
            for (ChessMove move : opponentMoves) {
                endPositions.add(move.getEndPosition());
                if (move.getEndPosition().equals(kingPosition)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.chessBoard = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return this.chessBoard;
    }

    private void setSquareNull(ChessPosition position) {
        this.chessBoard.addPiece(position, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGame chessGame = (ChessGame) o;
        return teamTurn == chessGame.teamTurn && Objects.equals(chessBoard, chessGame.chessBoard) && Objects.equals(validMoves, chessGame.validMoves) && Objects.equals(opponentMoves, chessGame.opponentMoves) && Objects.equals(endPositions, chessGame.endPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamTurn, chessBoard, validMoves, opponentMoves, endPositions);
    }
}

