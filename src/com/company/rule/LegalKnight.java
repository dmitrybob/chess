package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalKnight implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception {
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.KNIGHT)
            return true;
        int x = 1;
        int y = 2;
        if(move.to.y - x == move.from.y || move.to.y + x == move.from.y){
            if(move.to.x - y == move.from.x || move.to.x + y == move.from.x)
                return true;
        }
        else if(move.to.y - y == move.from.y || move.to.y + y == move.from.y){
            if(move.to.x - x == move.from.x || move.to.x + x == move.from.x){
                return true;
            }
        }
        throw new Exception("knight - incorrect move");
    }
}
