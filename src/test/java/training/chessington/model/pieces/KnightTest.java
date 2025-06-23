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


}
