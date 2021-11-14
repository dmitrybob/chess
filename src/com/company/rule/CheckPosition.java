package com.company.rule;

import com.company.Board;
import com.company.Enums.Color;
import com.company.Enums.Figure;

import static com.company.Board.getConverter;

public class CheckPosition implements Rule {
    @Override
    public boolean check(String move, Board board) {
        if(board.whiteTurn){
            if(move.charAt(0) == 'P') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.PAWN)
                        return true;
            }
            if(move.charAt(0) == 'R') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.ROOK)
                        return true;
            }
            if(move.charAt(0) == 'N') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.KNIGHT)
                        return true;
            }
            if(move.charAt(0) == 'B') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.BISHOP)
                        return true;
            }
            if(move.charAt(0) == 'Q') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.QUEEN)
                        return true;
            }
            if(move.charAt(0) == 'K') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.KING)
                        return true;
            }
        }
        else{
            if(move.charAt(0) == 'P') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.PAWN)
                        return true;
            }
            if(move.charAt(0) == 'R') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.ROOK)
                        return true;
            }
            if(move.charAt(0) == 'N') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.KNIGHT)
                        return true;
            }
            if(move.charAt(0) == 'B') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.BISHOP)
                        return true;
            }
            if(move.charAt(0) == 'Q') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.QUEEN)
                        return true;
            }
            if(move.charAt(0) == 'K') {
                if(board.board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK)
                    if(board.board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.KING)
                        return true;
            }
        }
        return false;
    }
}
