package com.company;

import com.company.Enums.Color;
import com.company.Enums.Figure;
import com.company.Enums.Piece;

import java.util.Scanner;
// todo en passant
// todo stalemate
// todo insufficient material

//for later
// todo games from internet
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            if(board.pawnTransform()) {
                System.out.println("Enter the figure you want your pawn to become");
                while(true) {
                    String newFigure = scanner.nextLine();
                    Boolean b = false;
                    switch (newFigure) {
                        case "Queen":
                            board.getTransformedPawn().figure = Figure.QUEEN;
                            b = true;
                            break;
                        case "Rook":
                            board.getTransformedPawn().figure = Figure.ROOK;
                            b = true;
                            break;
                        case "Knight":
                            board.getTransformedPawn().figure = Figure.KNIGHT;
                            b = true;
                            break;
                        case "Bishop":
                            board.getTransformedPawn().figure = Figure.BISHOP;
                            b = true;
                            break;
                    }
                    if(b) {
                        break;
                    }
                    System.out.println("That is not a valid input");
                }
            }
            System.out.println("Please enter your next move:");
            String userInput = scanner.nextLine();
            if(userInput.equals("sb")) {
                board.showBoard();
                continue;
            }
            if(userInput.equals("wt")) {
                board.printTurn();
                continue;
            }
            if(!isLegalNotation(userInput) && !userInput.equals("0-0") && !userInput.equals("0-0-0")) {
                System.out.println("this is not a correctly written move");
                continue;
            }
            Board.notFirstMove = true;
            Move move = Board.stringToMove(userInput,  board.whiteTurn);

            boolean res = board.isLegalMove(move);
            if (res) {
                board.move(move);
                System.out.println("next move " + (board.whiteTurn ? "white" : "black"));
                Color color = board.whiteTurn ? Color.WHITE : Color.BLACK;
                if (board.isCheck(color))
                    System.out.println("CHECK!");
            }
        }
    }

    static String Pieces = "NBKQR";
    static String Letters = "abcdefgh";
    static String Numbers = "12345678";

    public static boolean isLegalNotation(String move) {
        if(move.length() == 5) {
            if (Pieces.indexOf(move.charAt(0)) != -1) {
                if (Letters.indexOf(move.charAt(1)) != -1 && Letters.indexOf(move.charAt(3)) != -1) {
                    if (Numbers.indexOf(move.charAt(2)) != -1 && Numbers.indexOf(move.charAt(2)) != -1) {
                        return true;
                    }
                }
            }
        }
        if(move.length() == 4) {
            if (Letters.indexOf(move.charAt(0)) != -1 && Letters.indexOf(move.charAt(2)) != -1) {
                if (Numbers.indexOf(move.charAt(1)) != -1 && Numbers.indexOf(move.charAt(3)) != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}