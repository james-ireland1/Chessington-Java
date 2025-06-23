package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> output = new ArrayList<>();

        Coordinates upRight = new Coordinates(-1,1);
        Coordinates downRight = new Coordinates(1,1);
        Coordinates downLeft = new Coordinates(1,-1);
        Coordinates upLeft = new Coordinates(-1,-1);

        output.addAll(this.getAllMovesInOneDirection(from, board, upRight));
        output.addAll(this.getAllMovesInOneDirection(from, board, downRight));
        output.addAll(this.getAllMovesInOneDirection(from, board, downLeft));
        output.addAll(this.getAllMovesInOneDirection(from, board, upLeft));


        return output;
    }
}
