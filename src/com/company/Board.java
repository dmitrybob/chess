package com.company;

public class Board{

    public Piece[][] board = new Piece[8][8];
    private Rule[] rules = {
        new LegalNotation(),
        new LegalPawn(),
        new LegalRook(),
        new LegalKnight(),
        new LegalBishop()
    };

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

    public boolean isLegalKing(String move){
        int x = 1;
        if(move.charAt(4) == move.charAt(2)){
            if(move.charAt(1) == move.charAt(3) - x)
                return true;
            else if(move.charAt(1) == move.charAt(3) + x)
                return true;
        }

        if(move.charAt(1) == move.charAt(3)){
            if(move.charAt(4) == move.charAt(2) - x)
                return true;
            else if(move.charAt(4) == move.charAt(2) + x)
                return true;
        }

        if(move.charAt(4) - x == move.charAt(2) && move.charAt(1) - x == move.charAt(3)){
            return true;
        }

        return false;
    }

    public boolean isLegalQueen(String move){
        int x = move.charAt(4) - move.charAt(2);
        if(move.charAt(4) - x == move.charAt(2) && move.charAt(1) - x == move.charAt(3)){
            return true;
        }
        if(move.charAt(1) == move.charAt(3) || move.charAt(2) == move.charAt(4)){
            return true;
        }
        return false;
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
                    board[getConverter(move, 3)][move.charAt(4)] = new Piece(Color.WHITE, Figure.PAWN);
                    board[getConverter(move, 1)][move.charAt(2)] = null;
                    whiteTurn = !whiteTurn;
                }
            }
            if (!whiteTurn) {
                if (board[getConverter(move, 1)][getConverter(move, 2)].color == Color.BLACK && board[getConverter(move, 1)][getConverter(move, 2)].figure == Figure.PAWN) {
                    board[getConverter(move, 3)][getConverter(move, 4)] = new Piece(Color.BLACK, Figure.PAWN);
                    board[getConverter(move, 1)][getConverter(move, 2)] = null;
                    whiteTurn = !whiteTurn;
                }
            }
        }
    }

    public void move(String move) {
        /* boolean whiteTurn = true;
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
        } */
    }

    public boolean isLegalMove(String move){
        for(Rule rule: rules)
            if(!rule.check(move, this))
                return false;
        return true;
    }
        /*if(isLegalNotation(move)) {
            if (move.charAt(0) == 'P') {
                if (isLegalMovePawn(move))
                    return true;
            }
            if (move.charAt(0) == 'R') {
                if (isLegalMoveRook(move))
                    return true;
            }
            if (move.charAt(0) == 'B') {
                if (isLegalBishop(move))
                    return true;
            }
            if (move.charAt(0) == 'N') {
                if (isLegalKnight(move))
                    return true;
            }
            if (move.charAt(0) == 'K') {
                if (isLegalKing(move))
                    return true;
            }
            if (move.charAt(0) == 'Q') {
                if (isLegalQueen(move))
                    return true;
            }
        }
        return false;
    }
         */
}

