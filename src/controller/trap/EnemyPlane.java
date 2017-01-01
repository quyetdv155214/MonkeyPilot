package controller.trap;

import controller.*;
import controller.item.FireCircle;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

/**
 * Created by quyet on 12/27/2016.
 */
public class EnemyPlane extends Controller implements Body {
    EnemyMoveBehavior enemyMoveBehavior;
    AttackBehavior attackBehavior;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    public static final int a = 150;
    public static final int b = 0;
    private ShootBehavior shootBehavior;
    private int timeCounter =0 ;

    public static int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public EnemyPlane(Model model, View view, EnemyMoveBehavior enemyMoveBehavior, AttackBehavior attackBehavior,ShootBehavior shootBehavior) {
        super(model, view);
//        moveVector = new GameVector(0,1);
        this.enemyMoveBehavior = enemyMoveBehavior;
        this.attackBehavior = attackBehavior;
        BodyManager.instance.register(this);
        this.shootBehavior = shootBehavior;
    }

    private void shoot() {

        if (shootBehavior != null){

            shootBehavior.doShot(this);
        }
    }
    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void run() {
        super.run();
        if (enemyMoveBehavior != null)
        {
            enemyMoveBehavior.doMove(this);
        }
        if (attackBehavior instanceof  Explosion){
            this.attackBehavior.doAttack(this);
//            this.model.destroy();
        }
        timeCounter++;
        if (timeCounter > 300) {
            shoot();
            timeCounter = 0;
        }
    }

    public static EnemyPlane create(int x , int y, EnemyType enemyType ){

        Vector<BufferedImage> images = new Vector<>();
        EnemyPlane e;
        switch (enemyType){
            case GASDEC:
                images.add(Utils.loadImage("resources/plane1.png"));
                 e= new EnemyPlane(
                        new Model(x, y, WIDTH, HEIGHT),
                        new Animation(images),
                        new MoveStraight(),
                        new GasDec(),
                         null
                );

                return e;
            case LIFEDEC:
                images.add(Utils.loadImage("resources/31013559_Fighter_Plane.png"));
               e  = new EnemyPlane(
                        new Model(x, y, WIDTH * 2, HEIGHT),
                        new Animation(images),
                        new MoveInLine(),
                        new LifeDec(),
                         new ShootOnTargetBehavior()
                );
                return e;
            case EXPLOSION:
                images.add(Utils.loadImage("resources/mine.png"));
                e  = new EnemyPlane(
                        new Model(x, y, WIDTH , HEIGHT),
                        new Animation(images),
                        new MoveStraight(),
                        new Explosion(),
                        null
                );
                return e;
        }



        return null;

    }
//    public static EnemyPlane create(){
//        Vector<BufferedImage> images = new Vector<>();
//        images.add(Utils.loadImage("resources/plane.png"));
//        Random r = new Random();
//        int x = r.nextInt(GameSetting.instance.getWidth() * 2) +GameSetting.instance.getWidth();
//        int y = r.nextInt(GameSetting.instance.getHeight() - HEIGHT) +100;
//        EnemyPlane enemyPlane = create(x, y,);
//        return enemyPlane;
//    }

    @Override
    public void onContact(Body other) {
        if (other instanceof FireCircle) {
            this.getModel().destroy();
        }
        if(other instanceof Planecontroller){
           this.attackBehavior.doAttack(this);
        }

    }
}
