package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        //Allowed moves for a pawn - forward once, forward twice, diagonally left once, diagonally right once
        List<Move> output = new ArrayList<>();
        Integer dir = (this.getColour() == PlayerColour.WHITE) ? -1 : 1;
        Integer startRow = (this.getColour() == PlayerColour.WHITE) ? 6 : 1;
        Coordinates forwardOnce = from.plus(1*dir,0); //only allowed if space is empty
        Coordinates forwardTwice = from.plus(2*dir,0); //only allowed if it is the first move, and forwardOnce AND forwardTwice are empty
        Coordinates left = from.plus(1*dir,1*dir); //only allowed if space is occupied
        Coordinates right = from.plus(1*dir, -1*dir); //only allowed if space is occupied
        if (board.containsCoord(forwardOnce)) {
            if (board.get(forwardOnce) == null) {
                output.add(new Move(from, forwardOnce));
            }
        }
        if (board.containsCoord(forwardTwice)) {
            if (board.get(forwardOnce) == null && board.get(forwardTwice) == null && from.getRow() == startRow) {
                output.add(new Move(from, forwardTwice));
            }
        }
        if (board.containsCoord(left)) {
            if (board.get(left) != null && board.get(left).getColour() != this.getColour()) {
                output.add(new Move(from, left));
            }
        }
        if (board.containsCoord(right)) {
            if (board.get(right) != null && board.get(right).getColour() != this.getColour()) {
                output.add(new Move(from, right));
            }
        }
        return output;
    }
}
