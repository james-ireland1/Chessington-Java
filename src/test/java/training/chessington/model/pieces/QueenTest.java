package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {
    @Test
    public void whiteQueenCanMoveUpRightOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 3);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
    }

    @Test
    public void whiteQueenCanMoveDownLeftOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 3);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
    }
}
