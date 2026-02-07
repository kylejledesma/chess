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
        ChessPiece piece = chessBoard.getPiece(startPosition);
        ChessBoard testBoard = new ChessBoard();
        Collection<ChessMove> validMoves = piece.pieceMoves(chessBoard, startPosition);
        Collection<ChessMove> invalidMoves = new ArrayList<>();
        for (ChessMove move : validMoves) {
            testBoard = cloneBoard(chessBoard, testBoard);
            testBoard = makeMove(testBoard, move);
            if (isInCheck(piece.getTeamColor(), testBoard)){
                invalidMoves.add(move);
            }
        }
        validMoves.removeAll(invalidMoves);
        return validMoves;
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
        for (ChessMove testMove : validMoves(move.getStartPosition())) {
            if (move.equals(testMove)) {
                ChessPiece piece = chessBoard.getPiece(move.getStartPosition());
                this.chessBoard.addPiece(move.getEndPosition(), piece);
                this.chessBoard.addPiece(move.getStartPosition(), null);
                if (this.teamTurn == TeamColor.WHITE) { this.teamTurn = TeamColor.BLACK; }
                else { this.teamTurn = TeamColor.WHITE; }
                return;
            }
        } throw new InvalidMoveException();
    }

    /**
     * Overloaded makeMove for test case
     * @param testBoard
     * @param move
     */
    public ChessBoard makeMove(ChessBoard testBoard, ChessMove move) {
        ChessPiece piece = testBoard.getPiece(move.getStartPosition());
        testBoard.addPiece(move.getEndPosition(), piece);
        setSquareNull(move.getStartPosition(), testBoard);
        return testBoard;
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        ChessPosition kingPosition = getPiecePosition(teamColor, ChessPiece.PieceType.KING);
        ArrayList<ChessMove> opponentMoves = new ArrayList<>(getEnemyPositions(teamColor));
        for (ChessMove move : opponentMoves) {
            if (move.getEndPosition().equals(kingPosition)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Overload for testBoard
     * @param teamColor
     * @return
     */
    public boolean isInCheck(TeamColor teamColor, ChessBoard testBoard) {
        ChessPosition kingPosition = getPiecePosition(teamColor, ChessPiece.PieceType.KING, testBoard);
        ArrayList<ChessMove> opponentMoves = new ArrayList<>(getEnemyPositions(teamColor, testBoard));
        for (ChessMove move : opponentMoves) {
            if (move.getEndPosition().equals(kingPosition)) {
                return true;
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
     * Overload for testBoard
     * @param teamColor
     * @param pieceType
     * @param testBoard
     * @return
     */
    private ChessPosition getPiecePosition(TeamColor teamColor, ChessPiece.PieceType pieceType, ChessBoard testBoard) {
        for (int i = 0; i < testBoard.getBoard().length; i++) {
            for (int j = 0; j < testBoard.getBoard()[i].length; j++) {
                if (testBoard.getBoard()[i][j] == null) {
                    // Pass this null spot and check the next one
                } else if (testBoard.getBoard()[i][j].getTeamColor() == teamColor &&
                        testBoard.getBoard()[i][j].getPieceType() == pieceType) {
                    return new ChessPosition(i+1, j+1); // Remember to increment values of i and j
                }
            }
        } return null;
    }

    /**
     * Gets Collection of next turn enemy possible positions
     * @param teamColor
     * @return Collection<ChessMove>
     */
    private Collection<ChessMove> getEnemyPositions(TeamColor teamColor){
        Collection<ChessMove> enemyMoves = new ArrayList<>();
        // For testing
        ChessPiece testPiece;

        for (int i = 0; i < chessBoard.getBoard().length; i++) {
            for (int j = 0; j < chessBoard.getBoard()[i].length; j++) {
                if (chessBoard.getBoard()[i][j] == null) {
                } else if (chessBoard.getBoard()[i][j] == null) {

                } else if (chessBoard.getBoard()[i][j].getTeamColor() != teamColor) {
                    // Test function
                    testPiece = chessBoard.getBoard()[i][j];

                    Collection<ChessMove> singlePieceMoves = new ArrayList<>();
                    singlePieceMoves = chessBoard.getBoard()[i][j].pieceMoves(chessBoard, new ChessPosition(i+1, j+1));
                    enemyMoves.addAll(singlePieceMoves);
                }
            }
        }
        return enemyMoves;
    }

    /**
     * Overloaded method for the testBoard
     * @param teamColor
     * @param testBoard
     * @return
     */
    private Collection<ChessMove> getEnemyPositions(TeamColor teamColor, ChessBoard testBoard){
        Collection<ChessMove> enemyMoves = new ArrayList<>();
        // For testing
        ChessPiece testPiece;

        for (int i = 0; i < testBoard.getBoard().length; i++) {
            for (int j = 0; j < testBoard.getBoard()[i].length; j++) {
                if (testBoard.getBoard()[i][j] == null) {
                } else if (testBoard.getBoard()[i][j] == null) {

                } else if (testBoard.getBoard()[i][j].getTeamColor() != teamColor) {
                    // Test function
                    testPiece = testBoard.getBoard()[i][j];

                    Collection<ChessMove> singlePieceMoves = new ArrayList<>();
                    singlePieceMoves = testBoard.getBoard()[i][j].pieceMoves(testBoard, new ChessPosition(i+1, j+1));
                    enemyMoves.addAll(singlePieceMoves);
                }
            }
        }
        return enemyMoves;
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

    /**
     * Clones a board into a testBoard for checks
     * @param board1
     * @param board2
     * @return
     */
    private ChessBoard cloneBoard(ChessBoard board1, ChessBoard board2) {
        for (int i = 0; i < board1.getBoard().length; i++) {
            for (int j = 0; j < board1.getBoard()[i].length; j++) {
                board2.getBoard()[i][j] = board1.getBoard()[i][j];
            }
        }
        return board2;
    }

    /**
     * Removes piece from a position post-move
     * @param position
     * @param board
     */
    private void setSquareNull(ChessPosition position, ChessBoard board){
        board.addPiece(position, null);
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
