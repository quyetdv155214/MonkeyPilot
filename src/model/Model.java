package model;

/**
 * Created by Dell on 17/12/2016.
 */
public class Model {
    private double x;
    private double y;
    private int width;
    private int height;


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Model(double x, double y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void move(double dx,double dy){
        x+= dx;
        y+= dy;

    }
}
