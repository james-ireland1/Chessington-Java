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

        output.addAll(this.getAllMovesInOneDirection(from, board, upUpRight, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, upRightRight, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, downRightRight, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, downDownRight, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, downDownLeft, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, downLeftLeft, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, upLeftLeft, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, upUpLeft, 1));

        return output;
    }
}
