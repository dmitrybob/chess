package com.company;

import static com.company.Board.getConverter;

public class LegalBishop implements Rule{
    @Override
    public boolean check(String move, Board board) {
        if (move.charAt(0) != 'B')
            return true;

        int a = getConverter(move, 1) + 1;
        int b = getConverter(move, 2) + 2;
        int z = getConverter(move, 2);
        int c = getConverter(move, 3) + 1;
        int d = getConverter(move, 4) + 1;
        int x = move.charAt(4) - move.charAt(2);

        if(move.charAt(4) - x == move.charAt(2) && move.charAt(1) - x == move.charAt(3)) {
            for (int i = a-1; i > c; i--) {
                if (board.board[i][z] != null)
                    return false;
                z--;
            }
            return true;
        }
        else if(move.charAt(4) - x == move.charAt(2) && move.charAt(1) + x == move.charAt(3)) {
            for (int i = a+1; i < c; i++) {
                if (board.board[i][b] != null)
                    return false;
                b++;
            }
            return true;
        }
        else if(move.charAt(4) + x == move.charAt(2) && move.charAt(1) - x == move.charAt(3))
            return true;

        else if(move.charAt(4) + x == move.charAt(2) && move.charAt(1) + x == move.charAt(3))
            return true;

        return false;
    }
}
