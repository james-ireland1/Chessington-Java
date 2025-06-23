package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
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

        output.addAll(this.getAllMovesInOneDirection(from, board, up));
        output.addAll(this.getAllMovesInOneDirection(from, board, upRight));
        output.addAll(this.getAllMovesInOneDirection(from, board, right));
        output.addAll(this.getAllMovesInOneDirection(from, board, downRight));
        output.addAll(this.getAllMovesInOneDirection(from, board, down));
        output.addAll(this.getAllMovesInOneDirection(from, board, downLeft));
        output.addAll(this.getAllMovesInOneDirection(from, board, left));
        output.addAll(this.getAllMovesInOneDirection(from, board, upLeft));


        return output;
    }
}
