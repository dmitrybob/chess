package com.company.rule;

import com.company.Board;

import com.company.Enums.Piece;
import com.company.Move;


public class CheckPosition implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        if(move == Move.SHORT_CASTLE || move == Move.LONG_CASTLE)
            return true;
        Piece piece = board.pieceAt(move.from);
        if(piece == null || piece.color != move.color)
            throw new Exception("That figure is not your color");


        if(piece == null || piece.figure != move.figure)
            throw new Exception("the figure you want to move is not their");

        return true;
    }
}
