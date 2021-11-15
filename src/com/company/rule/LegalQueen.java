package com.company.rule;

import com.company.Board;

import static com.company.Board.getConverter;

public class LegalQueen implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if (move.charAt(0) != 'Q')
            return true;

        int a = getConverter(move, 1) + 1;
        int b = getConverter(move, 2) + 2;
        int r = getConverter(move, 2) + 1;
        int z = getConverter(move, 2);
        int c = getConverter(move, 3) + 1;
        int d = getConverter(move, 4) + 1;
        int x = move.charAt(4) - move.charAt(2);
        int h = move.charAt(3) - move.charAt(1);
        //bishop like movements
        if(move.charAt(4) - x == move.charAt(2) && move.charAt(3) - h == move.charAt(1)) {
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
            else if(x > 0 && h < 0){
                for (int i = a - 1; i < c; i--) {
                    if (board.board[i-1][b-1] != null)
                        return false;
                    b++;
                }
            }
            return true;
        }
        //Rook like movements
        if(move.charAt(1) == move.charAt(3)) {
            if(r < d){
                for (int i = r+1; i < d; i++) {
                    if (board.board[a-1][i-1] != null) {
                        return false;
                    }
                }
            }
            else{
                for (int i = d+1; i < r; i++) {
                    if (board.board[a-1][i-1] != null) {
                        return false;
                    }
                }
            }
        }
        else if(move.charAt(2) == move.charAt(4)){
            if(a < x) {
                for (int i = a + 1; i < d; i++) {
                    if (board.board[i-1][r-1] != null) {
                        return false;
                    }
                }
            }
            else{
                for (int i = x + 1; i < a; i++) {
                    if (board.board[i-1][r-1] != null) {
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
