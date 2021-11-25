package com.company.rule;

import com.company.Board;

import com.company.Enums.Piece;
import com.company.Move;


public class CheckPosition implements Rule {
    @Override
    public boolean check(Move move, Board board) {
        Piece piece = board.pieceAt(move.from);
        if(piece == null || piece.color != move.color)

            return false;

        if(piece == null || piece.figure != move.figure)
            return false;

        return true;
    }
}
