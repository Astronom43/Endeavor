package ru.doge.hierarchy.data.principles.geometry;

import lombok.Getter;

@Getter
public class Circle implements Geometry {

    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getSquare() {
        return 0;
    }
}
