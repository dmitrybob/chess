package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        bugs to fix
        Eating is not working well for everyone other than pawns
        Pieces are not in positions their supposed to be
         */
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            System.out.println("Please enter your next move:");
            String move = scanner.nextLine();
            boolean res = board.isLegalMove(move);
            if (res) {
                System.out.println("your last move was legal");
                board.move(move);
            } else {
                //System.out.println("your last move was not legal");
            }
        }
    }
}