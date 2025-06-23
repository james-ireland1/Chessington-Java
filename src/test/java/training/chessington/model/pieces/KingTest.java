package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {
    @Test
    public void whiteKingCanMoveOnceInAllDirections() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3,3);
        board.placePiece(coords, king);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,-1)));
    }

    @Test
    public void blackKingCanMoveOnceInAllDirections() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3,3);
        board.placePiece(coords, king);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,-1)));
    }

    @Test
    public void whiteKingCannotMoveOffBottomEdge() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,4);
        board.placePiece(coords, king);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,-1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,-1)));
    }

    @Test
    public void blackKingCannotMoveOffTopEdge() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,4);
        board.placePiece(coords, king);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,-1)));
    }

    @Test
    public void whiteKingCanTakeBlackPawn() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece blackPawn = new Pawn(PlayerColour.BLACK);
        Coordinates blackPawnCoords = new Coordinates(3,3);
        board.placePiece(blackPawnCoords, blackPawn);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
    }

    @Test
    public void blackKingCannotTakeBlackPawn() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece blackPawn = new King(PlayerColour.BLACK);
        Coordinates blackPawnCoords = new Coordinates(3,3);
        board.placePiece(blackPawnCoords, blackPawn);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,0)));
    }

    @Test
    public void whiteKingCannotMoveMoreThanOneSpace() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2,2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0,2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2,2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2,-1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2,-2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,-2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0,-2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,-2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2,-2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2,-1)));
    }

    @Test
    public void blackKingCannotMoveIntoCheck() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(3,7);
        board.placePiece(rookCoords, rook);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,1)));
    }

    @Test
    public void blackKingCanCrossPathOfBlackRook() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(3,7);
        board.placePiece(rookCoords, rook);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-1,-1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1,1)));
    }

    @Test
    public void whiteKingCannotMoveIntoCheck() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(3,3);
        board.placePiece(pawnCoords, pawn);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0,-1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0,0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0,1)));
    }


    @Test
    public void whiteKingMustMoveOutOfCheck() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates bishopCoords = new Coordinates(7,0);
        board.placePiece(bishopCoords, bishop);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,-1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1,1)));
    }

    @Test
    public void whiteKingVsBlackKing() {
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4,3);
        board.placePiece(coords, king);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(5,4);
        board.placePiece(blackCoords, blackKing);

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1,0)));

        assertThat(moves).contains(new Move(coords, coords.plus(1,1)));
    }
}
