package com.company.rule;

import com.company.Board;
import com.company.Enums.Figure;
import com.company.Enums.Piece;
import com.company.Move;

public class LegalQueen implements Rule {
    @Override
    public boolean check(Move move, Board board) {
        Piece piece = board.pieceAt(move.from);

        if (piece == null || piece.figure != Figure.QUEEN)
            return true;

        Rule bishop = new LegalBishop();
        Rule rook = new LegalRook();

        return bishop.check(move, board) || rook.check(move, board);
    }
}
