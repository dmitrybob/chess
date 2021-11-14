package com.company.rule;

import com.company.Board;

import static com.company.Board.getConverter;

public class LegalBishop implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if (move.charAt(0) != 'B')
            return true;

        int a = getConverter(move, 1) + 1;
        int b = getConverter(move, 2) + 2;
        int z = getConverter(move, 2);
        int c = getConverter(move, 3) + 1;
        int x = move.charAt(4) - move.charAt(2);
        int h = move.charAt(3) - move.charAt(1);

        if(move.charAt(4) - x == move.charAt(2) && move.charAt(3) - x == move.charAt(1)) {
            if(x < 0 && h < 0) {
                for (int i = a - 1; i > c; i--) {
                    if (board.board[i - 1][z - 1] != null)
                        return false;
                    z--;
                }
            }
            else if(x > 0 && h > 0) {
                for (int i = a + 1; i < c; i++) {
                    if (board.board[i-1][b-1] != null)
                        return false;
                    b++;
                }
            }
            else if(x < 0 && h > 0){
                for (int i = a + 1; i < c; i++) {
                    if (board.board[i-1][z-1] != null)
                        return false;
                    z--;
                }
            }
            else{
                for (int i = a - 1; i < c; i--) {
                    if (board.board[i-1][b-1] != null)
                        return false;
                    b++;
                }
            }
            return true;
        }
        return false;
    }
}
