package com.company;

import com.company.Enums.Color;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.rule.*;

public class Board{

    public static final int SIZE = 8;
    public Piece[][] board = new Piece[8][8];
    boolean whiteKingHasMoved = false;
    boolean blackKingHasMoved = false;
    boolean whiteRookOneHasMoved = false;
    boolean whiteRookTwoHasMoved = false;
    boolean blackRookOneHasMoved = false;
    boolean blackRookTwoHasMoved = false;

    private Rule[] preMoveRules = {
        new LegalPawn(),
        new LegalRook(),
        new LegalKnight(),
        new LegalBishop(),
        new LegalKing(),
        new LegalQueen(),
        new CheckPosition(),
        new IsSameColor(),
        new CheckIfPiecesMoved(),
        new CastleUnderCheck(),
        new CastlePiecesInWay()
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
        if(userInput.equals("0-0"))
            return Move.SHORT_CASTLE;
        if(userInput.equals("0-0-0"))
            return Move.LONG_CASTLE;
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

    public static char intToChr(int n) {
        int x = 0;
        switch (n) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
        }

        return 'g';
    }

    public void updateBoard(Move move){
        if(move == Move.SHORT_CASTLE) {
            if (whiteTurn) {
                board[4][0] = null;
                board[0][0] = null;
                board[6][0] = new Piece(Color.WHITE, Figure.KING);
                board[5][0] = new Piece(Color.WHITE, Figure.ROOK);
            } else {
                board[4][7] = null;
                board[1][7] = null;
                board[6][7] = new Piece(Color.BLACK, Figure.KING);
                board[5][7] = new Piece(Color.BLACK, Figure.ROOK);
            }
            return;
        }
        if(move == Move.LONG_CASTLE) {
            if (whiteTurn) {
                board[4][0] = null;
                board[1][0] = null;
                board[3][0] = new Piece(Color.WHITE, Figure.KING);
                board[4][0] = new Piece(Color.WHITE, Figure.ROOK);
            } else {
                board[4][7] = null;
                board[0][7] = null;
                board[3][7] = new Piece(Color.BLACK, Figure.KING);
                board[4][7] = new Piece(Color.BLACK, Figure.ROOK);
            }
            return;
        }
        board[move.from.x][move.from.y] = null;
        board[move.to.x][move.to.y] = new Piece(move.color, move.figure);
        if(board[move.to.x][move.to.y].color == Color.WHITE && board[move.to.x][move.to.y].figure == Figure.KING)
            whiteKingHasMoved = true;
        else if(board[move.to.x][move.to.y].color == Color.BLACK && board[move.to.x][move.to.y].figure == Figure.KING)
            blackKingHasMoved = true;
        else if(move.from.x == 0 && board[move.to.x][move.to.y].color == Color.WHITE)
                whiteRookOneHasMoved = true;
        else if(move.from.x == 7 && board[move.to.x][move.to.y].color == Color.WHITE)
                whiteRookTwoHasMoved = true;
        else if(move.from.x == 0 && board[move.to.x][move.to.y].color == Color.BLACK)
                blackRookOneHasMoved = true;
        else if(move.from.x == 7 && board[move.to.x][move.to.y].color == Color.BLACK)
                blackRookTwoHasMoved = true;
    }

    public boolean hasMoved(Color color, Move move){
        if(color == Color.WHITE && move == Move.SHORT_CASTLE)
            if(!whiteKingHasMoved && !whiteRookTwoHasMoved)
                return true;
        if(color == Color.WHITE && move == Move.LONG_CASTLE)
            if(!whiteKingHasMoved && !whiteRookOneHasMoved)
                return true;
        if(color == Color.BLACK && move == Move.SHORT_CASTLE)
            if(!whiteKingHasMoved && !blackRookTwoHasMoved)
                return true;
        if(color == Color.BLACK && move == Move.LONG_CASTLE)
            if(!whiteKingHasMoved && !blackRookOneHasMoved)
                return true;
        return false;
    }

    public void move(Move move) {
        updateBoard(move);
        whiteTurn = !whiteTurn;
    }

    public void printTurn(){
        String turn = "";
        if(whiteTurn)
            turn = "White Turn";
        else
            turn = "Black Turn";

        System.out.println(turn);
    }

    public boolean isLegalMove(Move move){
        for(Rule rule: preMoveRules) {
            try {
                rule.check(move, this);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        Board throwAwayBoard = new Board(this);
        throwAwayBoard.move(move);

        for(Rule rule: postMoveRules) {
            try {
                rule.check(move, throwAwayBoard);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        return true;
    }

    public boolean isCheck(Color kingColor){
        //color is the color of the king
        Color otherColor = kingColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        Cell kingPos = null;

        // find king position
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
                    // try a next move and see if it hits the king
                    Move tentativeMove = new Move(board[i][j].figure, otherColor, figurePos, kingPos);
                    // is any rule broken?
                    boolean isIllegal = false;
                    for(Rule rule: preMoveRules) {
                        try {
                            rule.check(tentativeMove, this);
                        } catch (Exception e) {
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

    public boolean castleIsCheck(Move move, Color kingColor){
        Color otherColor = kingColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        Cell kingPos = null;
        int r = otherColor == Color.WHITE ? 0 : 7;
        int c = move == Move.SHORT_CASTLE ? 5 : 3;
        int x = 0;
        int y = move == Move.SHORT_CASTLE ? 2 : 3;
        while(x < y) {
            if(x == 2)
                kingPos = new Cell(r, c);
            else
                kingPos = new Cell(r, c);
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == null || board[i][j].figure == Figure.KING)
                        continue;
                    if (board[i][j].color == otherColor) {
                        Cell figurePos = new Cell(i, j);
                        // try a next move and see if it hits the king
                        Move tentativeMove = new Move(board[i][j].figure, otherColor, figurePos, kingPos);
                        // is any rule broken?
                        boolean isIllegal = false;
                        for (Rule rule : preMoveRules) {
                            try {
                                rule.check(tentativeMove, this);
                            } catch (Exception e) {
                                isIllegal = true;
                                break;
                            }
                        }

                        if (!isIllegal) {
                            return true;
                        }
                    }
                }
            }
            x++;
            if(move == Move.SHORT_CASTLE)
                c++;
            else
                c--;
        }
        return false;
    }

    public boolean castleArePiecesInWay(Move move, Color color){
        int y = color == Color.WHITE ? 0 : 7;
        if(move == Move.SHORT_CASTLE)
            if(board[y][5] == null && board[y][6] == null)
                    return false;
        if(move == Move.LONG_CASTLE)
            if(board[y][2] == null && board[y][3] == null && board[y][4] == null)
                return false;
        return true;
    }

    public String positionToString(Figure figure, int x, int y){
        String s = "";
        switch (figure) {
            case PAWN:
                s = "";
                break;
            case ROOK:
                s = "R";
                break;
            case KNIGHT:
                s = "N";
                break;
            case BISHOP:
                s = "B";
                break;
            case QUEEN:
                s = "Q";
                break;
            case KING:
                s = "K";
                break;
        }
        s += intToChr(x);
        s += y + 1;
        s += " ";
        return s;
    }

    public void showBoard(){
        System.out.println("black pieces:");
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] != null && board[r][c].color == Color.BLACK){
                    System.out.print(positionToString(board[r][c].figure, r, c));
                }
            }
        }
        System.out.println();
        System.out.println("white pieces:");
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] != null && board[r][c].color == Color.WHITE){
                    System.out.print(positionToString(board[r][c].figure, r, c));
                }
            }
        }
        System.out.println();
    }
}

