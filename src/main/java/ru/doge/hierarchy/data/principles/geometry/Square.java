package ru.doge.hierarchy.data.principles.geometry;

import lombok.Getter;

@Getter
public class Square implements Geometry {

    private final double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double getSquare() {
        return this.a * this.a;
    }
}
