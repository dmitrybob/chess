package com.company.rule;

import com.company.Board;
import com.company.Rule;

public class LegalNotation implements Rule {
    static String Pieces = "PNBKQR";
    static String Letters = "abcdefgh";
    static String Numbers = "12345678";
    @Override
    public boolean check(String move, Board board) {
        if(move.length() == 5) {
            if (Pieces.indexOf(move.charAt(0)) != -1) {
                if (Letters.indexOf(move.charAt(1)) != -1 && Letters.indexOf(move.charAt(3)) != -1) {
                    if (Numbers.indexOf(move.charAt(2)) != -1 && Numbers.indexOf(move.charAt(2)) != -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
