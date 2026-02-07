package chess;

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
    private boolean inCheck;
    private boolean inStalemate;

    public ChessGame() {
        chessBoard.resetBoard();
        setTeamTurn(TeamColor.WHITE);
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
        throw new RuntimeException("Not implemented");
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to perform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        // Pre-move check: teamTurn is correct, piece exists in position
        checkPosition(move.getStartPosition());
        checkTeamTurn(chessBoard.getPiece(move.getStartPosition()).getTeamColor());

        ChessPiece piece = chessBoard.getPiece(move.getStartPosition());
        this.chessBoard.addPiece(move.getEndPosition(), piece);
        this.chessBoard.addPiece(move.getStartPosition(), null);
        if (this.teamTurn == TeamColor.WHITE) { this.teamTurn = TeamColor.BLACK; }
        else { this.teamTurn = TeamColor.WHITE; }
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
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
     * no valid moves while not in check.
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

    /**
     * Gets a specific piece's position
     *
     * @param teamColor
     * @param pieceType
     * @return ChessPosition
     */
    private ChessPosition getPiecePosition(TeamColor teamColor, ChessPiece.PieceType pieceType) {
        for (int i = 0; i < chessBoard.getBoard().length; i++) {
            for (int j = 0; j < chessBoard.getBoard()[i].length; j++) {
                if (chessBoard.getBoard()[i][j] == null) {
                    // Pass this null spot and check the next one
                } else if (chessBoard.getBoard()[i][j].getTeamColor() == teamColor &&
                        chessBoard.getBoard()[i][j].getPieceType() == pieceType) {
                    return new ChessPosition(i+1, j+1); // Remember to increment values of i and j
                }
            }
        }
        throw new RuntimeException("Piece not on board");
    }

    /**
     * Check that teamTurn matches
     * @param team
     * @return
     */
    public boolean checkTeamTurn(TeamColor team) throws InvalidMoveException {
        if (this.teamTurn == team) {
            return true;
        }else throw new InvalidMoveException();
    }

    /**
     * Check that piece exists in position
     * @param position
     * @return
     * @throws InvalidMoveException
     */
    public boolean checkPosition(ChessPosition position) throws InvalidMoveException {
        if (chessBoard.getPiece(position) == null) {
            throw new InvalidMoveException("No piece on that position!");
        } else return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessGame chessGame = (ChessGame) o;
        return inCheck == chessGame.inCheck && inStalemate == chessGame.inStalemate && teamTurn == chessGame.teamTurn && Objects.equals(chessBoard, chessGame.chessBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamTurn, chessBoard, inCheck, inStalemate);
    }
}
