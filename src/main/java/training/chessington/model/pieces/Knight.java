package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> output = new ArrayList<>();

        Coordinates upUpRight = new Coordinates(-2,1);
        Coordinates upRightRight = new Coordinates(-1,2);
        Coordinates downRightRight = new Coordinates(1,2);
        Coordinates downDownRight = new Coordinates(2,1);
        Coordinates downDownLeft = new Coordinates(2,-1);
        Coordinates downLeftLeft = new Coordinates(1,-2);
        Coordinates upLeftLeft = new Coordinates(-1,-2);
        Coordinates upUpLeft = new Coordinates(-2,-1);

        output.add(new Move(from, from.plus(upUpRight.getRow(), upUpRight.getCol())));
        output.add(new Move(from, from.plus(upRightRight.getRow(), upRightRight.getCol())));
        output.add(new Move(from, from.plus(downRightRight.getRow(), downRightRight.getCol())));
        output.add(new Move(from, from.plus(downDownRight.getRow(), downDownRight.getCol())));
        output.add(new Move(from, from.plus(downDownLeft.getRow(), downDownLeft.getCol())));
        output.add(new Move(from, from.plus(downLeftLeft.getRow(), downLeftLeft.getCol())));
        output.add(new Move(from, from.plus(upLeftLeft.getRow(), upLeftLeft.getCol())));
        output.add(new Move(from, from.plus(upUpLeft.getRow(), upUpLeft.getCol())));

        return output;
    }
}
