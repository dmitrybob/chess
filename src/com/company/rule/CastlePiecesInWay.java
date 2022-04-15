package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Move;

public class CastlePiecesInWay implements Rule{
    @Override
    public boolean check(Move move, Board board) throws Exception {
        Color color = board.whiteTurn ? Color.WHITE : Color.BLACK;
        if(move != Move.SHORT_CASTLE && move != Move.LONG_CASTLE )
            return true;
        if(board.castleArePiecesInWay(move, color))
            throw new Exception("Cannot Castle - Pieces In Way");
        return true;

    }
}
