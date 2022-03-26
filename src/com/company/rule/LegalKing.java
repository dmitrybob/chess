package com.company.rule;
import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalKing implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception{
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.KING)
            return true;
        int x = 1;
        if(move.to.y == move.from.y){
            if(move.to.y == move.to.x - x)
                return true;
            else if(move.from.x == move.to.x + x)
                return true;
        }

        if(move.from.x == move.to.x){
            if(move.to.y == move.from.y - x)
                return true;
            else if(move.to.y == move.from.y + x)
                return true;
        }

        if(move.to.y - x == move.from.y && move.from.x - x == move.to.x){
            return true;
        }

        throw new Exception("king - incorrect move");
    }
}
