package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalQueen implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        if(move == Move.SHORT_CASTLE || move == Move.LONG_CASTLE)
            return true;
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.QUEEN)
            return true;


        try {
            LegalBishop.isDiagonalMove(move, board);
            return true;
        } catch (Exception e) {}

        try {
            // if we are here - move is not diagonal
            LegalRook.isHorizontalVerticalMove(move, board);
            return true;
        } catch (Exception e) {
            throw new Exception("queen not diagonal or horizontal/vertical move");
        }
    }
}
