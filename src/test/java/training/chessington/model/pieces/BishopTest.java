package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    @Test
    public void whiteBishopCanMoveUpRightOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 2);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
    }

    @Test
    public void blackBishopCanMoveDownLeftOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 2);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
    }

    @Test
    public void whiteBishopCanTakeBlackPawn() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 3);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(2, 0);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
    }

    @Test
    public void blackBishopCanTakeWhitePawn() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(7, 7);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(7, 7)));
    }

    @Test
    public void whiteBishopCannotTakeWhitePawn() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 3);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(2, 0);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -3)));
    }

    @Test
    public void blackBishopCannotTakeBlackPawn() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(1, 6);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(2, 7);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void whiteBishopCannotFallOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 3);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, -4)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(5, -5)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(6, -6)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(7, -7)));
    }

    @Test
    public void blackBishopCannotFallOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 5);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 4)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(5, 5)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(6, 6)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(7, 7)));
    }

    @Test
    public void whiteBishopCannotMoveBeyondWhitePawn() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(2, 3);
        board.placePiece(coords, bishop);
        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(4, 5);
        board.placePiece(pawnCoords, pawn);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 4)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(5, 5)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(6, 6)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(7, 7)));
    }
}
