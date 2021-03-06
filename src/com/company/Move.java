package com.company;

import com.company.Enums.Color;
import com.company.Enums.Figure;

public class Move {

    public static Move SHORT_CASTLE = new Move(Figure.KING, Color.WHITE, null, null);
    public static Move LONG_CASTLE = new Move(Figure.KING, Color.WHITE, null, null);
    public Figure figure;
    public Color color;
    public Cell from;
    public Cell to;

    public Move(Figure figure, Color color, Cell from, Cell to) {
        this.figure = figure;
        this.color = color;
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return figure + " " + color + " " + from  + to;
    }
}
