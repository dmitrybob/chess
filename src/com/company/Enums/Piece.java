package com.company.Enums;

import com.company.Enums.Color;
import com.company.Enums.Figure;

import java.util.Objects;

public class Piece {
   public Color color;
   public Figure figure;
   public boolean firstMove = false;
    public Piece(Color color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && figure == piece.figure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, figure);
    }
}
