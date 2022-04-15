package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalRook implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        if(move == Move.SHORT_CASTLE || move == Move.LONG_CASTLE)
            return true;
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.ROOK)
            return true;

        return isHorizontalVerticalMove(move, board);

    }

    public static boolean isHorizontalVerticalMove(Move move, Board board) throws Exception {
        // check if legal move
        if(move.from.x != move.to.x && move.from.y != move.to.y)
            throw new Exception("rook - not horizontal or vertical move");


        // check no figure in the way
        int steps = Math.max(Math.abs(move.to.x - move.from.x),  Math.abs(move.to.y - move.from.y));
        int i = move.from.x, j = move.from.y, count = 0;
        while (count < steps) {

            if(count != 0 && board.pieceAt(i, j) != null) {
                throw new Exception("rook - figure in the way");
            }

            // move on to next step
            count++;
            if( move.to.x - move.from.x > 0)
                i++;
            else if (move.to.x - move.from.x < 0)
                i--;
            else {
                if (move.to.y - move.from.y > 0)
                    j++;
                else
                    j--;
            }
        }

        return true;

    }

}
