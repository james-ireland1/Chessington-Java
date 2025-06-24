package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Bishop extends AbstractPiece {

    private List<Coordinates> directions = List.of(
            new Coordinates(-1,1), //up right
            new Coordinates(1,1),  //down right
            new Coordinates(1,-1), //down left
            new Coordinates(-1,-1) //up left
    );

    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return directions.stream()
                .map(d -> getAllMovesInOneDirection(from, board, d))
                .flatMap(Collection::stream)
                .toList();
    }
}
