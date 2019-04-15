package com.mathefuchs.model;

import java.util.Random;
import java.util.function.Predicate;

public class Point {

    public static final Point ZERO = new Point(0, 0);

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point randomPointInRect(Random random, Point size) {
        return new Point(random.nextInt(size.getX()), random.nextInt(size.getY()));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void applyTranslationIfPlaceEmpty(Point point, Point boardSize, Predicate<Point> checkWhetherPlaceEmpty) {
        if (point != null) {
            int oldX = x;
            int oldY = y;
            x = (x + point.getX() + boardSize.getX()) % boardSize.getX();
            y = (y + point.getY() + boardSize.getY()) % boardSize.getY();

            if (!checkWhetherPlaceEmpty.test(this)) {
                x = oldX;
                y = oldY;
            }
        }
    }
}
