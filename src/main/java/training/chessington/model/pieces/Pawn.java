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
        int dir = (this.getColour() == PlayerColour.WHITE) ? -1 : 1;
        int startRow = (this.getColour() == PlayerColour.WHITE) ? 6 : 1;
        Coordinates forwardOnce = from.plus(1*dir,0); //only allowed if space is empty
        Coordinates forwardTwice = from.plus(2*dir,0); //only allowed if it is the first move, and forwardOnce AND forwardTwice are empty
        Coordinates fwdLeft = from.plus(1*dir,1*dir); //only allowed if space is occupied
        Coordinates fwdRight = from.plus(1*dir, -1*dir); //only allowed if space is occupied
        Coordinates left = from.plus(0,1*dir);
        Coordinates right = from.plus(0,-1*dir);


        if (board.containsCoord(forwardOnce) && board.isSpaceEmpty(forwardOnce)) {
            output.add(new Move(from, forwardOnce));
        }
        if (board.containsCoord(forwardTwice) && board.isSpaceEmpty(forwardOnce) && board.isSpaceEmpty(forwardTwice) && !this.hasMoved) {
            output.add(new Move(from, forwardTwice));
        }
        if (board.containsCoord(fwdLeft) && (board.isSpaceEnemy(fwdLeft,this) || (board.isSpaceEmpty(fwdLeft) && board.isSpaceEnemy(left,this)))) {
            output.add(new Move(from, fwdLeft));
        }
        if (board.containsCoord(fwdRight) && (board.isSpaceEnemy(fwdRight,this) || (board.isSpaceEmpty(fwdRight) && board.isSpaceEnemy(right,this)))) {
            output.add(new Move(from, fwdRight));
        }
        return output;
    }
}
