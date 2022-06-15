package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Enums.Figure;
import com.company.Move;

public class Checkmate implements Rule{
    @Override
    public boolean check(Move move, Board board) throws Exception {
        Color color = board.whiteTurn ? Color.WHITE : Color.BLACK;
        if(!board.isCheck(color))
            return true;
        if(board.kingAbleToMove(color) || board.pieceBlocks(color))
            return true;
        throw new Exception("CHECKMATE!");
    }
}
