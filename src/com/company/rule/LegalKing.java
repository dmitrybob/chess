package com.company.rule;
import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalKing implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception{
        if(move == Move.SHORT_CASTLE || move == Move.LONG_CASTLE)
            return true;
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.KING)
            return true;
        if(move.to.y == move.from.y){
            if(move.from.x == move.to.x - 1)
                return true;
            else if(move.from.x == move.to.x + 1)
                return true;
        }

        if(move.from.x == move.to.x){
            if(move.to.y == move.from.y - 1)
                return true;
            else if(move.to.y == move.from.y + 1)
                return true;
        }

        if(move.to.y - 1 == move.from.y && move.from.x - 1 == move.to.x)
            return true;

        if(move.to.y + 1 == move.from.y && move.from.x + 1 == move.to.x)
            return true;

        if(move.to.y + 1 == move.from.y && move.from.x - 1 == move.to.x)
            return true;

        if(move.to.y - 1 == move.from.y && move.from.x + 1 == move.to.x)
            return true;

        throw new Exception("king - incorrect move");
    }
}
