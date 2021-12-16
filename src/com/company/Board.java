package com.company;

import com.company.Enums.Color;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.rule.*;

public class Board{

    public static final int SIZE = 8;
    public Piece[][] board = new Piece[8][8];

    private Rule[] preMoveRules = {
        new LegalPawn(),
        new LegalRook(),
        new LegalKnight(),
        new LegalBishop(),
        new LegalKing(),
        new LegalQueen(),
        new CheckPosition(),
        new IsSameColor()
    };

    private Rule[] postMoveRules = {
        new CheckRule()
    };

    public boolean whiteTurn = true;

    public Board(Board toCopy) {
        whiteTurn = toCopy.whiteTurn;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = toCopy.board[i][j];
            }
        }
    }

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

    public Piece pieceAt(Cell cell) {
        return board[cell.x][cell.y];
    }

    public Piece pieceAt(int x, int y) {
        return board[x][y];
    }

    public static Move stringToMove(String userInput, boolean isWhiteTurn) {

        Figure figure = null;
        switch (userInput.charAt(0)) {
            case 'P':
                figure = Figure.PAWN;
                break;
            case 'K':
                figure = Figure.KING;
                break;
            case 'N':
                figure = Figure.KNIGHT;
                break;
            case 'B':
                figure = Figure.BISHOP;
                break;
            case 'R':
                figure = Figure.ROOK;
                break;
            case 'Q':
                figure = Figure.QUEEN;
                break;
            default:
                break;
        }

        int x1 = charToInt(userInput.charAt(1));
        int y1 = userInput.charAt(2) - '1';
        int x2 = charToInt(userInput.charAt(3));
        int y2 = userInput.charAt(4) - '1';

        Color color = isWhiteTurn ? Color.WHITE : Color.BLACK;
        Move move = new Move(figure, color, new Cell(x1, y1), new Cell(x2, y2));

        return move;
    }

    private static int charToInt(char c) {
        int x = 0;
        switch (c) {
            case 'a':
                x = 0;
                break;
            case 'b':
                x = 1;
                break;
            case 'c':
                x = 2;
                break;
            case 'd':
                x = 3;
                break;
            case 'e':
                x = 4;
                break;
            case 'f':
                x = 5;
                break;
            case 'g':
                x = 6;
                break;
            case 'h':
                x = 7;
                break;
        }

        return x;
    }

    public void updateBoard(Move move){
        board[move.from.x][move.from.y] = null;
        board[move.to.x][move.to.y] = new Piece(move.color, move.figure);
    }

    public void move(Move move) {
        updateBoard(move);
        whiteTurn = !whiteTurn;
    }

    public boolean isLegalMove(Move move){
        int x = 0;
        for(Rule rule: preMoveRules) {
            x++;
            if(!rule.check(move, this)) {
                if(x == 1){
                    System.out.println("This is not a legal pawn move or a piece is in the way");
                }
                if(x == 2){
                    System.out.println("This is not a legal rook move or a piece is in the way");
                }
                if(x == 3){
                    System.out.println("This is not a legal knight move or a piece is in the way");
                }
                if(x == 4){
                    System.out.println("This is not a legal bishop move or a piece is in the way");
                }
                if(x == 5){
                    System.out.println("This is not a legal king move or a piece is in the way");
                }
                if(x == 6){
                    System.out.println("This is not a legal queen move or a piece is in the way");
                }
                if(x == 7){
                    System.out.println("That piece is not in that square");
                }
                if(x == 8){
                    System.out.println("You have a piece on that square");
                }
                return false;
            }
        }

        Board throwAwayBoard = new Board(this);
        throwAwayBoard.move(move);

        for(Rule rule: postMoveRules) {
            if(!rule.check(move, throwAwayBoard)) {
                System.out.println("not allowed opens check");
                return false;
            }
        }

        return true;
    }

    public boolean isCheck(Color kingColor){
        //color is the color of the king
        Color otherColor = kingColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        Cell kingPos = null;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == null)
                    continue;
                if(board[i][j].figure == Figure.KING && board[i][j].color == kingColor) {
                    kingPos = new Cell(i, j);
                    break;
                }
            }
        }

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == null || board[i][j].figure == Figure.KING)
                    continue;
                if(board[i][j].color == otherColor) {
                    Cell figurePos = new Cell(i, j);
                    Move tentativeMove = new Move(board[i][j].figure, otherColor, figurePos, kingPos);
                    // is any rule broken?
                    boolean isIllegal = false;
                    for(Rule rule: preMoveRules) {
                        if(!rule.check(tentativeMove, this)) {
                            isIllegal = true;
                            break;
                        }
                    }

                    if(!isIllegal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

