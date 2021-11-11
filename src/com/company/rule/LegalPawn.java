package com.company.rule;

import com.company.Board;
import com.company.Rule;

import static com.company.Board.getConverter;

public class LegalPawn implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if (move.charAt(0) != 'P')
            return true;
        int a = getConverter(move, 1) + 1;
        int b = getConverter(move, 2) + 1;
        int x = getConverter(move, 3) + 1;
        int y = getConverter(move, 4) + 1;
        if (a == x) {
            if (b == y - 1) {
                if(board.board[x-1][y-1] == null)
                    return true;
            }
            else if (b == 2 && b == y - 2) {
                for (int i = b; i <= y-1; i++) {
                    if (board.board[x-1][i] != null)
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
