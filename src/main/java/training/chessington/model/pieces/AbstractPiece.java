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

    public boolean canMoveHere(Board board, Coordinates to) {
        return board.containsCoord(to) && (board.isSpaceEmpty(to) || board.isSpaceEnemy(to, this));
    }

    private List<Move> getMaxMovesInOneDirection(Coordinates from, Board board, Coordinates step, int maxSteps) { //return all the valid moves a piece can make by repeating 'step'
        List<Move> moves = new ArrayList<>();
        Coordinates to;
        for (int i = 1; i <= maxSteps; i++) {
            to = from.plus(step.getRow()*i, step.getCol()*i);
            if (this.canMoveHere(board, to)) {
                moves.add(new Move(from, to));
            }
            if (!board.isSpaceEmpty(to)) { //if space is occupied, piece cannot continue moving beyond it
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
