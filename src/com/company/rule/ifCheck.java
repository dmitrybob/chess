package com.company.rule;

import com.company.Board;
import com.company.Cell;
import com.company.Enums.Color;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class ifCheck implements Rule{
    @Override
    public boolean check(Move move, Board board) {
        Move pieceToWKing = null;
        Move pieceToBKing = null;
        if(move.from == null)
            return true;
        if(board.whiteTurn){
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++){
                    if(board.board[i][j] == null)
                        continue;
                    if(board.board[i][j].figure == Figure.KING && board.board[i][j].color == Color.BLACK) {
                        Cell blackKingPos = new Cell(i, j);
                        pieceToBKing = new Move(Figure.KING, Color.WHITE, move.from, blackKingPos);
                        break;
                    }
                }
            }
        }
        else{
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 7; j++){
                    if(board.board[i][j].figure == Figure.KING && board.board[i][j].color == Color.BLACK) {
                        Cell whiteKingPos = new Cell(i, j);
                        pieceToWKing = new Move(Figure.KING, Color.WHITE, move.from, whiteKingPos);
                        break;
                    }
                }
            }
        }

        if(board.whiteTurn)
            return board.isLegalMove(pieceToBKing);
        else
            return board.isLegalMove(pieceToWKing);
        }
}

