package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    private List<Coordinates> directions = List.of(
            new Coordinates(-2,1),  //up up right
            new Coordinates(-1,2),  //up right right
            new Coordinates(1,2),   //down right right
            new Coordinates(2,1),   //down down right
            new Coordinates(2,-1),  //down down left
            new Coordinates(1,-2),  //down left left
            new Coordinates(-1,-2), //up left left
            new Coordinates(-2,-1)  //up up left
    );

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return directions.stream()
                .map(d -> getAllMovesInOneDirection(from, board, d, 1))
                .flatMap(Collection::stream)
                .toList();
    }
}
