package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Move;

public class CheckRule implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        Color color = board.whiteTurn ? Color.BLACK : Color.WHITE;
        if(board.isCheck(color))
            throw new Exception("You can not open your king to check");
        else
            return true;
    }
}