package com.company.rule;

import com.company.Board;
import com.company.Rule;

public class LegalKing implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if (move.charAt(0) != 'K')
            return true;
        int x = 1;
        if(move.charAt(4) == move.charAt(2)){
            if(move.charAt(1) == move.charAt(3) - x)
                return true;
            else if(move.charAt(1) == move.charAt(3) + x)
                return true;
        }

        if(move.charAt(1) == move.charAt(3)){
            if(move.charAt(4) == move.charAt(2) - x)
                return true;
            else if(move.charAt(4) == move.charAt(2) + x)
                return true;
        }

        if(move.charAt(4) - x == move.charAt(2) && move.charAt(1) - x == move.charAt(3)){
            return true;
        }

        return false;
    }
}
