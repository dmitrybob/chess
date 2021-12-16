package com.company;

import com.company.Enums.Color;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // todo move not same
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            System.out.println("Please enter your next move:");
            String userInput = scanner.nextLine();
            if(!isLegalNotation(userInput)) {
                System.out.println("this is not a correctly written move");
                continue;
            }

            Move move = Board.stringToMove(userInput,  board.whiteTurn);

            boolean res = board.isLegalMove(move);
            if (res) {
                board.move(move);
                Color color = board.whiteTurn ? Color.WHITE : Color.BLACK;
                if(board.isCheck(color))
                    System.out.println("CHECK!");

            }
        }
    }

    static String Pieces = "PNBKQR";
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
        return false;
    }
}