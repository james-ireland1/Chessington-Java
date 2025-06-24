package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {
    @Test
    public void whiteKnightCanMoveUpUpRight() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,1);
        board.placePiece(coords, knight);

        List<Move> moves = knight.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-2,1)));
    }

    @Test
    public void blackKnightCanMoveDownDownRight() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,6);
        board.placePiece(coords, knight);

        List<Move> moves = knight.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(2,1)));
    }

    @Test
    public void whiteKnightInCornerOnlyHasTwoMoves() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0,0);
        board.placePiece(coords, knight);

        List<Move> moves = knight.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(1,2)));
        assertThat(moves).contains(new Move(coords, coords.plus(2,1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 2)));
    }

    @Test
    public void blackKnightCanCaptureWhitePawn() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,1);
        board.placePiece(coords, knight);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(2,2);
        board.placePiece(pawnCoords, pawn);

        List<Move> moves = knight.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(2,1)));
    }

    @Test
    public void whiteKnightCannotCaptureWhitePawn() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,6);
        board.placePiece(coords, knight);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(6,4);
        board.placePiece(pawnCoords, pawn);

        List<Move> moves = knight.getAllowedMoves(coords, board);


        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -2)));
    }
}
