package training.chessington.model;

import training.chessington.model.pieces.*;

import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private Piece[][] board = new Piece[8][8];
    public boolean isProvisional = false;

    private Board() {
    }

    public static Board forNewGame() {
        Board board = new Board();
        board.setBackRow(0, PlayerColour.BLACK);
        board.setBackRow(7, PlayerColour.WHITE);

        for (int col = 0; col < 8; col++) {
            board.board[1][col] = new Pawn(PlayerColour.BLACK);
            board.board[6][col] = new Pawn(PlayerColour.WHITE);
        }

        return board;
    }

    public static Board empty() {
        return new Board();
    }

    private void setBackRow(int rowIndex, PlayerColour colour) {
        board[rowIndex][0] = new Rook(colour);
        board[rowIndex][1] = new Knight(colour);
        board[rowIndex][2] = new Bishop(colour);
        board[rowIndex][3] = new Queen(colour);
        board[rowIndex][4] = new King(colour);
        board[rowIndex][5] = new Bishop(colour);
        board[rowIndex][6] = new Knight(colour);
        board[rowIndex][7] = new Rook(colour);
    }

    public boolean containsCoord(Coordinates coord) {
        return coord.getRow() >= 0 && coord.getRow() < 8 && coord.getCol() >= 0 && coord.getCol() < 8;
    }

    public boolean isSpaceUnderAttack(Coordinates defenderCoord) {
        return IntStream.range(0, this.board.length)
                .mapToObj(row -> IntStream.range(0, this.board[row].length)
                        .mapToObj(col -> {
                            Coordinates attackerCoord = new Coordinates(row, col);
                            if (isSpaceEmpty(attackerCoord)) {return false;}
                            Piece attackerPiece = this.get(attackerCoord); //I don't need to check if the other piece is a different colour, as a friendly piece cannot take a friendly piece anyway
                            return attackerPiece.getAllowedMoves(attackerCoord, this).contains(new Move(attackerCoord, defenderCoord));
                        })
                        .reduce(false, (partial, next) -> partial || next))
                .reduce(false, (partial, next) -> partial || next);


//        for (int row = 0; row < this.board.length; row++) {
//            for (int col = 0; col < this.board[row].length; col++) {
//                Coordinates attackerCoord = new Coordinates(row, col);
//                if (isSpaceEmpty(attackerCoord)) {continue;}
//                Piece attackerPiece = this.get(attackerCoord); //I don't need to check if the other piece is a different colour, as a friendly piece cannot take a friendly piece anyway
//                if (attackerPiece.getAllowedMoves(attackerCoord,this).contains(new Move(attackerCoord,defenderCoord))) {
//                    return true;
//                }
//            }
//        }
//        return false;

    }

    public Board copy() {
        Board copy = Board.empty();
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                copy.board[row][col] = this.board[row][col];
            }
        }
        return copy;
    }

    public Board makeProvisionalMove(Move move) {
        Board copy = this.copy();
        copy.isProvisional = true;
        copy.move(move.getFrom(), move.getTo());
        return copy;
    }

    public boolean isSpaceEmpty(Coordinates coord) {
        return this.containsCoord(coord) && this.get(coord) == null;
    }

    public boolean isSpaceEnemy(Coordinates coord, Piece piece) {
        //return (this.containsCoord(coord) && this.get(coord) != null) ? this.get(coord).getColour() != piece.getColour() : false;

        return this.containsCoord(coord) && this.get(coord) != null && this.get(coord).getColour() != piece.getColour();

//        if (this.containsCoord(coord)) {
//            if (this.get(coord) != null) {
//                return this.get(coord).getColour() != piece.getColour();
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
    }

    public Piece get(Coordinates coords) {
        return board[coords.getRow()][coords.getCol()];
    }

    public void move(Coordinates from, Coordinates to) {
        if (moveIsEnPassant(from, to)) {
            board[from.getRow()][to.getCol()] = null;
        }
        board[to.getRow()][to.getCol()] = board[from.getRow()][from.getCol()];
        board[from.getRow()][from.getCol()] = null;
        board[to.getRow()][to.getCol()].setHasMoved();
    }

    public boolean moveIsEnPassant(Coordinates from, Coordinates to) {
        if (from.getRow() == to.getRow() || from.getCol() == to.getCol()) {
            return false;
        }
        if (get(from).getType() != Piece.PieceType.PAWN) {
            return false;
        }
        return isSpaceEnemy(new Coordinates(from.getRow(), to.getCol()), get(from)) && isSpaceEmpty(to);
    }

    public void placePiece(Coordinates coords, Piece piece) {
        board[coords.getRow()][coords.getCol()] = piece;
    }
}
