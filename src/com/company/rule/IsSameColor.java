package com.company.rule;

import com.company.Board;
import com.company.Move;


public class IsSameColor implements Rule {
    @Override
    public boolean check(Move move, Board board) {
        if(board.pieceAt(move.to) == null)
            return true;

        return move.color != board.pieceAt(move.to).color;
    }
}