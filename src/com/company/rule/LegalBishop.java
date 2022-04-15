package com.company.rule;
import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalBishop implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        if(move == Move.SHORT_CASTLE || move == Move.LONG_CASTLE)
            return true;
        Piece piece = board.pieceAt(move.from);
        if (piece == null || piece.figure != Figure.BISHOP)
            return true;

        return isDiagonalMove(move, board);
    }

    public static boolean isDiagonalMove(Move move, Board board) throws Exception {
        int x = Math.abs(move.to.x - move.from.x);
        int y = Math.abs(move.to.y - move.from.y);
        if(x != y)
            throw new Exception("bishop - incorrect move");



        int i = move.from.x, j = move.from.y, count = 0;
        while (count < x) {

            if(count != 0 && board.pieceAt(i, j) != null) {
                throw new Exception("bishop - incorrect move");
            }

            // move on to next step
            count++;
            if( move.to.x - move.from.x > 0)
                i++;
            else
                i--;
            if( move.to.y - move.from.y > 0)
                j++;
            else
                j--;
        }

        return true;

    }

}
