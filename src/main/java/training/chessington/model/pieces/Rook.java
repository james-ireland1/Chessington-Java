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
        for (int i = 1; i <= 8; i++) {
            output.add(new Move(from, from.plus(up.getRow()*i, up.getCol()*i)));
        }

        //moving down
        Coordinates down = new Coordinates(1,0);
        for (int i = 1; i <= 8; i++) {
            output.add(new Move(from, from.plus(down.getRow()*i, down.getCol()*i)));
        }

        //to the left, to the left
        Coordinates left = new Coordinates(0,-1);
        for (int i = 1; i <= 8; i++) {
            output.add(new Move(from, from.plus(left.getRow()*i, left.getCol()*i)));
        }

        //sliiiiide to the right
        Coordinates right = new Coordinates(0,1);
        for (int i = 1; i <= 8; i++) {
            output.add(new Move(from, from.plus(right.getRow()*i, right.getCol()*i)));
        }

        return output;
    }
}
