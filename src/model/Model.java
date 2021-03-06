package model;

import controller.*;
import controller.managers.ControllerManager;
import util.Utils;
import view.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

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
    private int MAX_TIME_LIVE = 100;
    private int liveTime = 1;

    private int curTimeCount = 0;

    public void decGas() {
        curTimeCount++;
        if (curTimeCount > 50) {
            liveTime--;
            curTimeCount = 0;
        }
        if (liveTime <= 0)
            isAlive = false;
    }

    public void icsGas(int unit) {
        liveTime += unit;
        if (liveTime > MAX_TIME_LIVE)
            liveTime = MAX_TIME_LIVE;
        System.out.println("+ " + unit + " gas");
    }

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

    public GameVector subtract(Model model) {
        return new GameVector(this.x - model.x, this.y - model.y);
    }

    public void decHp(int dec) {
        hp -= dec;
        System.out.println(hp);
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

    public void destroy() {
        ExplosionController explosionController = new ExplosionController(new Model(this.x, this.y, this.width, this.height),
                new Animation(Utils.loadSheet("resources/enemy/explosion.png", 32, 32, 1, 6)));
        ControllerManager.explosion.controllers.add(explosionController);

        setAlive(false);

        Utils.playSound("resources/sound/play/Explosion8.wav", false);
    }
//    public void destroy2(){
//        ExplosionController explosionController = new ExplosionController(new Model(this.x,this.y,this.width,this.height),
//                new Animation(Utils.loadSheet("resources/AnimatedExplosion_ME1.png",128,149,0,7,6)));
//        ControllerManager.explosion.controllers.add(explosionController);
//       setAlive(false);
//
//        Utils.playSound("resources/Explosion8.wav", false);
//    }

    public double getMidX() {
        return this.x + this.width / 2;
    }

    public double getMidY() {
        return this.y + this.height / 2;
    }

    public double getBottom() {
        return this.y + this.height;
    }

    public int getMAX_TIME_LIVE() {
        return MAX_TIME_LIVE;
    }

    public void setMAX_TIME_LIVE(int MAX_TIME_LIVE) {
        this.MAX_TIME_LIVE = MAX_TIME_LIVE;
    }

    public int getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(int liveTime) {
        this.liveTime = liveTime;
    }

    public void drawHealthBar(Graphics g, int x, int y) {
        g.drawString("Gas ", x, y);
        g.drawRect(x, y, GameSetting.HEALTH_BAR_WIDTH, GameSetting.HEALTH_BAR_HEIGHT);

        if (liveTime
                < (MAX_TIME_LIVE / 5) && liveTime % 2 == 0) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.GREEN);

        }
        g.fillRect(x, y,
                liveTime *
                        (GameSetting.HEALTH_BAR_WIDTH / MAX_TIME_LIVE),
                GameSetting.HEALTH_BAR_HEIGHT);

    }


    public boolean checkout() {
        if (x <= 1 || x >= GameSetting.WIDTH - width - 1) {
            liveTime--;
            Utils.playSound("resources/sound/play/wall.wav",false);
//            System.out.println("cham");
            return true;
        } else if (y <= 31 || y >= GameSetting.HEIGHT - height - 1) {
            liveTime--;
            Utils.playSound("resources/sound/play/wall.wav",false);
            return true;

        } else return false;
    }

    public void check() {
        if (x <= 0) {
            x = 1;
        } else if (x >= (GameSetting.WIDTH - width)) {
            x = GameSetting.WIDTH - width - 1;
        }
        if (y <= 30) {
            y = 31;
        } else if (y >= GameSetting.HEIGHT - height)
            y = GameSetting.HEIGHT- height - 1;
    }

    public boolean checkDead() {
        if (!isAlive || x > GameSetting.WIDTH || y > GameSetting.HEIGHT
                || x < 0 || y < 0) {
            return true;
        } else return false;

    }
}
