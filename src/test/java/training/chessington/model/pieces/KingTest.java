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

        Piece blackPawn = new King(PlayerColour.BLACK);
        Coordinates blackPawnCoords = new Coordinates(3,3);

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

        List<Move> moves = king.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-1,0)));
    }
}
