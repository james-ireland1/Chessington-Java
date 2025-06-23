package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> output = new ArrayList<>();

        Coordinates up = new Coordinates(-1,0);
        Coordinates upRight = new Coordinates(-1,1);
        Coordinates right = new Coordinates(0,1);
        Coordinates downRight = new Coordinates(1,1);
        Coordinates down = new Coordinates(1,0);
        Coordinates downLeft = new Coordinates(1,-1);
        Coordinates left = new Coordinates(0,-1);
        Coordinates upLeft = new Coordinates(-1,-1);

        output.addAll(this.getAllMovesInOneDirection(from, board, up, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, upRight, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, right, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, downRight, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, down, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, downLeft, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, left, 1));
        output.addAll(this.getAllMovesInOneDirection(from, board, upLeft, 1));


        return output;
    }
}
