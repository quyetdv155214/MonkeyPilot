package model;

import controller.ExplosionController;
import controller.GameSetting;
import controller.GameVector;
import controller.TargetController;
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
    private  int MAX_TIME_LIVE = 100;
    private int liveTime =1;

    private int curTimeCount = 0;

    public void decGas(){
        curTimeCount++ ;
        if (curTimeCount > 50){
            liveTime--;
            curTimeCount =0;
        }
    }
    public void icsGas(int unit){
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
    public void destroy(){
        ExplosionController explosionController = new ExplosionController(new Model(this.x,this.y,this.width,this.height),
                new Animation(Utils.loadSheet("resources/explosion.png",32,32,1,6)));
        ControllerManager.explosion.controllers.add(explosionController);
        Utils.playSound("resources/Explosion8.wav", false);
    }
    public static void target(int x, int y){
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/target1.png"));
        images.add(Utils.loadImage("resources/target2.png"));
        images.add(Utils.loadImage("resources/target3.png"));
        images.add(Utils.loadImage("resources/target4.png"));
        images.add(Utils.loadImage("resources/target5.png"));
        images.add(Utils.loadImage("resources/target6.png"));

        TargetController pp = new TargetController(new Model(x, y,40,50),
                new Animation(images,5));
        System.out.println("ahihi");
        ControllerManager.explosion.controllers.add(pp);
//        Utils.playSound("resources/Explosion8.wav", false);
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


    public boolean checkout() {
        if (x < 0 || x > GameSetting.instance.getWidth() - width) {
            return true;
        } else if (y < 30 || y > GameSetting.instance.getHeight() - height)
            return true;
        else return false;
    }

    public boolean checkDead() {
        GameSetting g = GameSetting.instance;
        if (!isAlive || x > g.getWidth() ||  y > g.getHeight() || x < 0 || y < 0 || liveTime <= 0){
            return true;
        }
        else return  false;

    }
}
