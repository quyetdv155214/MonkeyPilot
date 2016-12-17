package model;

import java.awt.*;

/**
 * Created by Dell on 17/12/2016.
 */
public class Model {
    private int hp;
    private double x;
    private double y;
    private int width;
    private int height;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

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

    public Rectangle getRectangle(){
        return new Rectangle((int)x, (int)y, width, height);
    }

    public boolean interects(Model other){
        Rectangle rect1 = this.getRectangle();
        Rectangle rect2 = other.getRectangle();
        return rect1.intersects(rect2);
    }
}
