package com.company.rule;

import com.company.Board;
import com.company.Move;


public class IsSameColor implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        if(board.pieceAt(move.to) == null)
            return true;

       if(move.color == board.pieceAt(move.to).color)
           throw new Exception("You can not take your own piece");
       else
           return true;
    }
}