package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> output = new ArrayList<>();
        //moving on up
        Coordinates up = new Coordinates(-1,0);
        output.add(new Move(from, from.plus(up.getRow(), up.getCol())));

        //moving down
        Coordinates down = new Coordinates(1,0);
        output.add(new Move(from, from.plus(down.getRow(), down.getCol())));
        return output;
    }
}
