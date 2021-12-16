package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Move;

public class CheckRule implements Rule {
    @Override
    public boolean check(Move move, Board board) {
        Color color = board.whiteTurn ? Color.BLACK : Color.WHITE;
        return !board.isCheck(color);
    }
}