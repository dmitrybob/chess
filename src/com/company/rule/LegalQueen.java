package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalQueen implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.QUEEN)
            return true;



        boolean b = LegalBishop.isDiagonalMove(move, board);
        boolean r = LegalRook.isHorizontalVerticalMove(move, board);
        return b || r;
    }
}
