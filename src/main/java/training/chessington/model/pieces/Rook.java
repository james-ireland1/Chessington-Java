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
        Coordinates to;

        //this repeats the same thing 4 times for each direction - would be good to only have that code block once, haven't worked out how to do it yet...

        //moving on up
        Coordinates up = new Coordinates(-1,0);
        for (int i = 1; i <= 8; i++) {
            to = from.plus(up.getRow()*i, up.getCol()*i);
            if (board.containsCoord(to)) {
                output.add(new Move(from, to));
            } else {
                break;
            }
        }

        //moving down
        Coordinates down = new Coordinates(1,0);
        for (int i = 1; i <= 8; i++) {
            to = from.plus(down.getRow()*i, down.getCol()*i);
            if (board.containsCoord(to)) {
                output.add(new Move(from, to));
            } else {
                break;
            }
        }

        //to the left, to the left
        Coordinates left = new Coordinates(0,-1);
        for (int i = 1; i <= 8; i++) {
            to = from.plus(left.getRow()*i, left.getCol()*i);
            if (board.containsCoord(to)) {
                output.add(new Move(from, to));
            } else {
                break;
            }
        }

        //sliiiiide to the right
        Coordinates right = new Coordinates(0,1);
        for (int i = 1; i <= 8; i++) {
            to =  from.plus(right.getRow()*i, right.getCol()*i);
            if (board.containsCoord(to)) {
                output.add(new Move(from, to));
            } else {
                break;
            }
        }

        return output;
    }
}
