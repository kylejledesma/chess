package chess;

public class PieceMovesCalculator extends ChessPiece implements QueenMovesCalculator, KingMovesCalculator, PawnMovesCalculator,
RookMovesCalculator, KnightMovesCalculator {
    var pieceType = ChessPiece.PieceType();
    case(pieceType){
        case 'b': BishopMovesCalculator
    }
}

public interface BishopMovesCalculator {
    int[][] piecemoves[8][8];
    // logic for movement of bishop
    BishopMovesCalculator(ChessBoard board, ChessPiece pieceType){
        // diagonal for any distance as long as not blocked by own piece or until position of enemy piece
    }
    // returns array of applicable moves for the piece
    pieceMoves[][] = BishopMovesCalculator();
    return pieceMoves[][];
}

public interface KingMovesCalculator {
    // logic for movement of king
    // any direction for one space as long as not blocked by own piece or until position of enemy piece
    // include check considerations at later stage
    // returns array of applicable moves for the piece
}

public interface KnightMovesCalculator {
    // logic for movement of knight
    // forward any perpendicular direction for 2 and then either one left or one right, valid as long as
    // ... destination is not blocked by own piece and still within the array boundaries
    // returns array of applicable moves for the piece
}

public interface PawnMovesCalculator {
    // logic for movement of pawn
    // forward unless blocked by any piece
    // diagonal if diagonal position occupied by enemy piece
    // forward two spaces if from original starting position
    // can be promoted once arrived at opposite end of the board
    // returns array of applicable moves for the piece
}

public interface QueenMovesCalculator {
    // logic for movement of queen
    // any direction for any distance unless occupied by own piece or until enemy piece's position
    // returns array of applicable moves for the piece
}

public interface RookMovesCalculator {
    // logic for movement of rook
    // perpendicular direction for any distance as long as not blocked by own piece or until position of enemy piece
    // returns array of applicable moves for the piece
}