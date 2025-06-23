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

    public List<Move> checkKingCanMoveHere(Board board, Coordinates from, Coordinates direction) {
        List<Move> moves = new ArrayList<>();
        Coordinates to = from.plus(direction.getRow(),direction.getCol());
        if (board.containsCoord(to)) {
            Board provisionalBoard = board.makeProvisionalMove(new Move(from, to));
            if (!provisionalBoard.isSpaceUnderAttack(to, this.getColour())) {
                if (board.get(to) == null) {
                    moves.add(new Move(from, to));
                } else if (board.get(to).getColour() != this.getColour()) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> output = new ArrayList<>();

        Coordinates up = new Coordinates(-1,0);
        output.addAll(checkKingCanMoveHere(board,from,up));

        Coordinates upRight = new Coordinates(-1,1);
        output.addAll(checkKingCanMoveHere(board,from,upRight));

        Coordinates right = new Coordinates(0,1);
        output.addAll(checkKingCanMoveHere(board,from,right));

        Coordinates downRight = new Coordinates(1,1);
        output.addAll(checkKingCanMoveHere(board,from,downRight));

        Coordinates down = new Coordinates(1,0);
        output.addAll(checkKingCanMoveHere(board,from,down));

        Coordinates downLeft = new Coordinates(1,-1);
        output.addAll(checkKingCanMoveHere(board,from,downLeft));

        Coordinates left = new Coordinates(0,-1);
        output.addAll(checkKingCanMoveHere(board,from,left));

        Coordinates upLeft = new Coordinates(-1,-1);
        output.addAll(checkKingCanMoveHere(board,from,upLeft));



        return output;
    }
}
