package com.mathefuchs.model;

import java.util.Random;

public enum Direction {
    Top(0, -1),
    TopRight(1, -1),
    Right(1, 0),
    BottomRight(1, 1),
    Bottom(0, 1),
    BottomLeft(-1, 1),
    Left(-1, 0),
    TopLeft(-1, -1);

    private Point transformation;

    Direction(int x, int y) {
        this.transformation = new Point(x, y);
    }

    public static Direction randomDirection(Random random) {
        return Direction.values()[random.nextInt(Direction.values().length)];
    }

    public Point getTransformation() {
        return transformation;
    }
}
