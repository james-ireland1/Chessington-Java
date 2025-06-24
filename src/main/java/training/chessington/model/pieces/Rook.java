package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    private List<Coordinates> directions = List.of(
            new Coordinates(-1,0), //up
            new Coordinates(0,1),  //right
            new Coordinates(1,0),  //down
            new Coordinates(0,-1) //left
    );

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return directions.stream()
                .map(d -> getAllMovesInOneDirection(from, board, d))
                .flatMap(Collection::stream)
                .toList();
    }
}
