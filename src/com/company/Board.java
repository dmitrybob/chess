package com.company;

import com.company.Enums.Color;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.rule.*;

public class Board{

    public Piece[][] board = new Piece[8][8];

    private Rule[] rules = {
        new LegalNotation(),
        new LegalPawn(),
        new LegalRook(),
        new LegalKnight(),
        new LegalBishop(),
        new LegalKing(),
        new LegalQueen(),
        new CheckPosition(),
        new IsSameColor()
    };

    public boolean whiteTurn = true;

    public Board() {
        //White pieces
        board[0][0] = new Piece(Color.WHITE, Figure.ROOK);
        board[1][0] = new Piece(Color.WHITE, Figure.KNIGHT);
        board[2][0] = new Piece(Color.WHITE, Figure.BISHOP);
        board[3][0] = new Piece(Color.WHITE, Figure.QUEEN);
        board[4][0] = new Piece(Color.WHITE, Figure.KING);
        board[5][0] = new Piece(Color.WHITE, Figure.BISHOP);
        board[6][0] = new Piece(Color.WHITE, Figure.KNIGHT);
        board[7][0] = new Piece(Color.WHITE, Figure.ROOK);
        board[0][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[1][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[2][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[3][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[4][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[5][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[6][1] = new Piece(Color.WHITE, Figure.PAWN);
        board[7][1] = new Piece(Color.WHITE, Figure.PAWN);
        //Black pieces
        board[0][7] = new Piece(Color.BLACK, Figure.ROOK);
        board[1][7] = new Piece(Color.BLACK, Figure.KNIGHT);
        board[2][7] = new Piece(Color.BLACK, Figure.BISHOP);
        board[3][7] = new Piece(Color.BLACK, Figure.QUEEN);
        board[4][7] = new Piece(Color.BLACK, Figure.KING);
        board[5][7] = new Piece(Color.BLACK, Figure.BISHOP);
        board[6][7] = new Piece(Color.BLACK, Figure.KNIGHT);
        board[7][7] = new Piece(Color.BLACK, Figure.ROOK);
        board[0][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[1][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[2][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[3][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[4][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[5][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[6][6] = new Piece(Color.BLACK, Figure.PAWN);
        board[7][6] = new Piece(Color.BLACK, Figure.PAWN);
    }

    public static int getConverter(String move, int y){
        int x = 0;
        if(move.charAt(y) == 'a'){
            x = 0;
        }
        if(move.charAt(y) == 'b'){
            x = 1;
        }
        if(move.charAt(y) == 'c'){
            x = 2;
        }
        if(move.charAt(y) == 'd'){
            x = 3;
        }
        if(move.charAt(y) == 'e'){
            x = 4;
        }
        if(move.charAt(y) == 'f'){
            x = 5;
        }
        if(move.charAt(y) == 'g'){
            x = 6;
        }
        if(move.charAt(y) == 'h'){
            x = 7;
        }
        if(move.charAt(y) == '1'){
            x = 0;
        }
        if(move.charAt(y) == '2'){
            x = 1;
        }
        if(move.charAt(y) == '3'){
            x = 2;
        }
        if(move.charAt(y) == '4'){
            x = 3;
        }
        if(move.charAt(y) == '5'){
            x = 4;
        }
        if(move.charAt(y) == '6'){
            x = 5;
        }
        if(move.charAt(y) == '7'){
            x = 6;
        }
        if(move.charAt(y) == '8'){
            x = 7;
        }
        return x;
    }

    public void wbmove(boolean whiteTurn, Figure figure, String move){
        if(board[getConverter(move, 1)][getConverter(move, 2)] != null) {
            if (whiteTurn) {
                if (board[getConverter(move, 1)][getConverter(move, 2)].color == Color.WHITE && board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.PAWN) {
                    if(board[getConverter(move, 3)][getConverter(move, 4)] != null){
                        System.out.println("A piece was eaten");
                    }
                    board[getConverter(move, 3)][getConverter(move, 4)] = null;
                    board[getConverter(move, 3)][getConverter(move, 4)] = new Piece(Color.WHITE, Figure.PAWN);
                    board[getConverter(move, 1)][getConverter(move, 2)] = null;

                }
            }
            else{
                if (board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK && board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.PAWN) {
                    if(board[getConverter(move, 3)][getConverter(move, 4)] != null){
                        System.out.println("A piece was eaten");
                    }
                    board[getConverter(move, 3)][getConverter(move, 4)] = null;
                    board[getConverter(move, 3)][getConverter(move, 4)] = new Piece(Color.BLACK, Figure.PAWN);
                    board[getConverter(move, 1)][getConverter(move, 2)] = null;
                }
            }
        }
    }

    public void move(String move) {
        if(move.charAt(0) == 'P') {
            wbmove(whiteTurn, Figure.PAWN, move);
        }
        if(move.charAt(0) == 'R') {
            wbmove(whiteTurn, Figure.ROOK, move);
        }
        if(move.charAt(0) == 'N') {
            wbmove(whiteTurn, Figure.KNIGHT, move);
        }
        if(move.charAt(0) == 'B') {
            wbmove(whiteTurn, Figure.BISHOP, move);
        }
        if(move.charAt(0) == 'Q') {
            wbmove(whiteTurn, Figure.QUEEN, move);
        }
        if(move.charAt(0) == 'K') {
            wbmove(whiteTurn, Figure.KING, move);
        }
        whiteTurn = !whiteTurn;
    }

    public boolean isLegalMove(String move){
        int x = 0;
        for(Rule rule: rules) {
            x++;
            if(!rule.check(move, this)) {
                if(x == 1){
                    System.out.println("This is not a correctly written rule");
                }
                if(x == 2){
                    System.out.println("This is not a legal pawn move or a piece is in the way");
                }
                if(x == 3){
                    System.out.println("This is not a legal rook move or a piece is in the way");
                }
                if(x == 4){
                    System.out.println("This is not a legal knight move or a piece is in the way");
                }
                if(x == 5){
                    System.out.println("This is not a legal bishop move or a piece is in the way");
                }
                if(x == 6){
                    System.out.println("This is not a legal king move or a piece is in the way");
                }
                if(x == 7){
                    System.out.println("This is not a legal queen move or a piece is in the way");
                }
                if(x == 8){
                    System.out.println("That piece is not in that square");
                }
                if(x == 9){
                    System.out.println("You have a piece on that square");
                }
                return false;
            }
        }
        return true;
    }
}

