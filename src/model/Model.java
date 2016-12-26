package model;

import controller.GameSetting;
import controller.GameVector;

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
    private boolean isAlive = true;
    private GameVector gameMove;

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

    public Model(int hp, double x, double y, int width, int height, GameVector gameMove) {
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameMove = gameMove;
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

    public void move(double dx, double dy) {
        x += dx;
        y += dy;

    }

    public void move(GameVector gameVector) {
        move(gameVector.dx, gameVector.dy);

    }

    public Rectangle getRectangle() {
//        System.out.println(String.format("%s, %s", width, height));
        return new Rectangle((int) x, (int) y, width, height);
    }

    public void decHp(int dec) {
        hp -= dec;
        if (hp <= 0) {
            isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean interects(Model other) {
        Rectangle rect1 = this.getRectangle();
        Rectangle rect2 = other.getRectangle();
        return rect1.intersects(rect2);
    }

    public boolean checkout() {
        if (x < 0 || x > GameSetting.instance.getWidth() - width) {
            return true;
        } else if (y < 30 || y > GameSetting.instance.getHeight() - height)
            return true;
        else return false;
    }
}
