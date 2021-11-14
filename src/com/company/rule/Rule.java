package com.company.rule;

import com.company.Board;

public interface Rule {
    boolean check(String move, Board board);
}
