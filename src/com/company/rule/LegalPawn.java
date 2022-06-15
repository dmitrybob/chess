package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;


public class LegalPawn implements Rule {
    @Override
    public boolean check(Move move, Board board) throws Exception{
        if(move == Move.SHORT_CASTLE || move == Move.LONG_CASTLE)
            return true;
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
                            throw new Exception("pawn - figure is in the way");
                    }
                    return true;
                }
            }
        }
        // check if eats figure
        if(board.whiteTurn){
            if(move.to.y - 1 == move.from.y){
                if(move.to.x - 1 == move.from.x)
                    if(board.board[move.to.x][move.to.y]!= null)
                        return true;
                if(move.to.x + 1 == move.from.x)
                    if(board.board[move.to.x][move.to.y] != null)
                        return true;
            }
        }
        else{
            if(move.to.y + 1 == move.from.y){
                if(move.to.x - 1 == move.from.x)
                    if(board.board[move.to.x][move.to.y] != null)
                        return true;


                if(move.to.x + 1 == move.from.x)
                    if(board.board[move.to.x][move.to.y] != null)
                        return true;
            }
        }
        //check if en passant
        if(board.whiteTurn){
            if(move.from.y == 4 && move.to.y == 5){
                if(move.to.x == move.from.x + 1 || move.to.x == move.from.x - 1 ){
                    if(board.board[move.to.x][move.to.y - 1] != null)
                        if( board.board[move.to.x][move.to.y - 1].figure == Figure.PAWN)
                            if(board.board[move.to.x][move.to.y - 1].firstMove) {
                                board.board[move.to.x][move.to.y - 1] = null;
                                return true;
                            }
                            else
                                throw new Exception("pawn - Their is not piece for you to take");
                        else
                           throw new Exception("pawn - Their is not piece for you to take");
                }
            }
        }
        else{
            if(move.from.y == 3 && move.to.y == 2){
                if(move.to.x == move.from.x + 1 || move.to.x == move.from.x - 1){
                    if(board.board[move.to.x][move.to.y + 1] != null)
                        if(board.board[move.to.x][move.to.y + 1].figure == Figure.PAWN)
                            if(board.board[move.to.x][move.to.y + 1].firstMove) {
                                board.board[move.to.x][move.to.y + 1] = null;
                                return true;
                            }
                            else
                                throw new Exception("pawn - Their is not piece for you to take");
                        else
                            throw new Exception("pawn -Their is not piece for you to take");
                }
            }
        }
        throw new Exception("pawn - incorrect move");
    }
}
