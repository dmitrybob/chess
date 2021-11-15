package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;

import static com.company.Board.getConverter;

public class IsSameColor implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if(board.board[getConverter(move, 3)][getConverter(move, 4)] == null)
            return true;
        if (board.whiteTurn) {
            if (board.board[getConverter(move, 3)][getConverter(move, 4)].color == Color.WHITE)
                return false;
            else
                return true;
        }
        else{
            if (board.board[getConverter(move, 3)][getConverter(move, 4)].color == Color.BLACK)
                return false;
            else
                return true;
        }
    }
}