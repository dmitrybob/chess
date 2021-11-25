package com.company.rule;

import com.company.Board;
import com.company.Move;

public interface Rule {
    boolean check(Move move, Board board);
}
