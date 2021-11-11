package com.company;

import static com.company.Board.getConverter;

public class LegalRook implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if(move.charAt(0) != 'R')
            return true;
        int a = getConverter(move, 1) + 1;
        int b = getConverter(move, 2) + 1;
        int x = getConverter(move, 3) + 1;
        int y = getConverter(move, 4) + 1;
        if(move.charAt(1) == move.charAt(3)) {
            if(b < y){
                for (int i = b+1; i < y; i++) {
                    if (board.board[a-1][i-1] != null) {
                        return false;
                    }
                }
            }
            else{
                for (int i = y+1; i < b; i++) {
                    if (board.board[a-1][i-1] != null) {
                        return false;
                    }
                }
            }
        }
        else if(move.charAt(2) == move.charAt(4)){
            if(a < x) {
                for (int i = a + 1; i < y; i++) {
                    if (board.board[i-1][b-1] != null) {
                        return false;
                    }
                }
            }
            else{
                for (int i = x + 1; i < a; i++) {
                    if (board.board[i-1][b-1] != null) {
                        return false;
                    }
                }
            }

        }
        else
            return false;

        return true;
    }
}
