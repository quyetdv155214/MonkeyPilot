package controller;

import java.util.DoubleSummaryStatistics;

/**
 * Created by apple on 12/24/16.
 */
public class GameVector {
    public double dx;
    public double dy;

    public GameVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getLength() {
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void reverse() {
        this.dx = -dx;
        this.dy = -dy;
    }
    public void slow() {
        this.dx =  dx /2;
        this.dy =  dy /2;
    }
}
