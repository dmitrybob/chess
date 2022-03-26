package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;


public class LegalPawn implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception{
        Piece piece = board.pieceAt(move.from);
        if (piece == null || piece.figure != Figure.PAWN)
            return true;

        if (move.from.x == move.to.x) {
            if (board.whiteTurn){
                // if moves by one
                if (move.from.y == move.to.y - 1) {
                    // if moves to empty cell
                    if (board.board[move.to.x][move.to.y] == null)
                        return true;
                  // moves two squares from initial position
                } else if (move.from.y == 1 && move.from.y == move.to.y - 2) {
                    // check if figure in the way
                    for (int i = move.from.y + 1; i <= move.to.y; i++) {
                        if (board.board[move.to.x][i] != null)
                            throw new Exception("pawn - figure is in the way");
                    }
                    return true;
                }
            } else {
                if (move.from.y == move.to.y + 1) {
                    if (board.board[move.to.x][move.to.y] == null)
                        return true;
                } else if (move.from.y == 6 && move.from.y == move.to.y + 2) {
                    for (int i = move.from.y - 1; i >= move.to.y; i--) {
                        if (board.board[move.to.x][i] != null)
                            throw new Exception("pawn - incorrect move");;
                    }
                    return true;
                }
            }
        }
        // check if eats figure
        if(board.whiteTurn){
            if(move.to.y - 1 == move.from.y){
                if(move.to.x - 1 == move.from.x)
                    return !(board.board[move.to.x-1][move.to.y-1] == null);
                if(move.to.x + 1 == move.from.x)
                    return !(board.board[move.to.x+1][move.to.y-1] == null);
            }
        }
        else{
            if(move.to.y + 1 == move.from.y){
                if(move.to.x - 1 == move.from.x)
                    return !(board.board[move.to.x-1][move.to.y-1] == null);
                if(move.to.x + 1 == move.from.x)
                    return !(board.board[move.to.x+1][move.to.y-1] == null);
            }
        }
        throw new Exception("pawn - incorrect move");
    }
}
