package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Move;


public class IsSameColor implements Rule {
    @Override
    public boolean check(Move move, Board board) {
        if(board.pieceAt(move.to) == null)
            return true;

        if (board.whiteTurn)
            return !(board.pieceAt(move.to).color == Color.WHITE);
        else
            return !(board.pieceAt(move.to).color == Color.BLACK);


    }
}