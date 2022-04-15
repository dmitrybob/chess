package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Move;

public class CastleUnderCheck implements Rule{
    @Override
    public boolean check(Move move, Board board) throws Exception {
        Color color = board.whiteTurn ? Color.BLACK : Color.WHITE;
        if(move != Move.SHORT_CASTLE && move != Move.LONG_CASTLE )
            return true;
        if(!board.castleIsCheck(move, color))
            throw new Exception("Cannot Castle - Spaces in between are under check");
        return true;
    }
}
