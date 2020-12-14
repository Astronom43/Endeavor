package ru.doge.hierarchy.data.principles.geometry;

import lombok.Getter;

@Getter
public class Rectangle implements Geometry {

    private final double a;
    private final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSquare() {
        return this.a * this.b;
    }
}
