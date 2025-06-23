package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    private List<Move> getMaxMovesInOneDirection(Coordinates from, Board board, Coordinates step, int maxSteps) { //return all the valid moves a piece can make by repeating 'step'
        List<Move> moves = new ArrayList<>();
        Coordinates to;
        for (int i = 1; i <= maxSteps; i++) {
            to = from.plus(step.getRow()*i, step.getCol()*i);
            if (!board.containsCoord(to)) {break;}
            if (board.get(to) == null) {
                moves.add(new Move(from, to));
            } else {
                if (board.get(to).getColour() != this.getColour()) {moves.add(new Move(from, to));}
                break;
            }
        }
        return moves;
    }

    public List<Move> getAllMovesInOneDirection(Coordinates from, Board board, Coordinates step) {
        return getMaxMovesInOneDirection(from, board, step, 8);
    }

    public List<Move> getAllMovesInOneDirection(Coordinates from, Board board, Coordinates step, int maxSteps) {
        return getMaxMovesInOneDirection(from, board, step, maxSteps);
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
