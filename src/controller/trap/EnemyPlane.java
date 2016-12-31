package controller.trap;

import controller.Controller;
import controller.GameSetting;
import controller.GameVector;
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
public class EnemyPlane extends Controller {
    EnemyMoveBehavior enemyMoveBehavior;
    public static final int WIDTH = 120;
    public static final int HEIGHT = 50;

    public EnemyPlane(Model model, View view, EnemyMoveBehavior enemyMoveBehavior) {
        super(model, view);
//        moveVector = new GameVector(0,1);
        this.enemyMoveBehavior = enemyMoveBehavior;
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
    }

    public static EnemyPlane create(int x , int y){
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/plane.png"));
        EnemyPlane e  = new EnemyPlane(
                new Model(x, y, WIDTH, HEIGHT),
                new Animation(images),
                new MoveFollowY()
        );
        e.model.setMAX_TIME_LIVE(10);
        e.model.setLiveTime(10);
        return e;

    }
    public static EnemyPlane create(){
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/plane.png"));
        Random r = new Random();
        int x = r.nextInt(GameSetting.instance.getWidth() * 2) +GameSetting.instance.getWidth();
        int y = r.nextInt(GameSetting.instance.getHeight() - HEIGHT) +100;
        EnemyPlane enemyPlane = create(x, y);
        return enemyPlane;

    }
}
