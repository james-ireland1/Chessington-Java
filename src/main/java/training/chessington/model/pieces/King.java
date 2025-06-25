package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    private List<Coordinates> directions = List.of(
            new Coordinates(-1,0), //up
            new Coordinates(-1,1), //up right
            new Coordinates(0,1),  //right
            new Coordinates(1,1),  //down right
            new Coordinates(1,0),  //down
            new Coordinates(1,-1), //down left
            new Coordinates(0,-1), //left
            new Coordinates(-1,-1) //up left
    );

    public boolean checkKingCanMoveHere(Board board, Coordinates from, Coordinates to) {
        if (!board.containsCoord(to)) {
            return false;
        } else {
            Board provisionalBoard = board.makeProvisionalMove(new Move(from, to));
            return board.isProvisional || (canMoveHere(board, to) && !provisionalBoard.isSpaceUnderAttack(to));
        }
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        return directions.stream()
                .map(d -> from.plus(d.getRow(),d.getCol()))
                .map(t -> checkKingCanMoveHere(board, from, t) ? new Move(from, t) : null)
                .filter(t -> t != null)
                .toList();
    }
}
