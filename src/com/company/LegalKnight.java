package com.company;

public class LegalKnight implements Rule{
    @Override
    public boolean check(String move, Board board) {
        if (move.charAt(0) != 'N')
            return true;
        int x = 1;
        int y = 2;
        if(move.charAt(4) - x == move.charAt(2) || move.charAt(4) + x == move.charAt(2)){
            if(move.charAt(3) - y == move.charAt(1) || move.charAt(3) + y == move.charAt(1))
                return true;
        }
        else if(move.charAt(4) - y == move.charAt(2) || move.charAt(4) + y == move.charAt(2)){
            if(move.charAt(3) - x == move.charAt(1) || move.charAt(3) + x == move.charAt(1)){
                return true;
            }
        }
        return false;
    }
}
