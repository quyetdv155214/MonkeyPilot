package controller;

import controller.item.Helper;
import controller.managers.BodyManager;
import controller.trap.EnemyPlane;
import controller.trap.TrapController;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

/**
 * Created by quyet on 1/4/2017.
 */
public class StarController extends Controller implements Body {

    private static int count = 0;
    private boolean isAliveDiamon = true;

    public boolean getAliveDiamon() {
        return isAliveDiamon;
    }

    public void setAliveDiamon(boolean aliveDiamon) {
        isAliveDiamon = aliveDiamon;
    }
    public StarController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public static StarController instance = create(500, 400);

    private static StarController create(int x, int y) {
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/star/star1.png"));
        images.add(Utils.loadImage("resources/star/star2.png"));
        images.add(Utils.loadImage("resources/star/star3.png"));
        images.add(Utils.loadImage("resources/star/star4.png"));
        images.add(Utils.loadImage("resources/star/star5.png"));
        images.add(Utils.loadImage("resources/star/star6.png"));
//        images.add(Utils.loadImage("resources/star/star.png"));
        StarController starController = new StarController(
                new Model(x, y, 50, 50),
                new Animation(images,8));
        return starController;
    }

    @Override
    public void run() {
        super.run();
        if (!StarController.instance.getAliveDiamon()){
            count++;
            if (count > 400){
                count = 0;
                setNewLoc();
                StarController.instance.setAliveDiamon(true);
                BodyManager.instance.register(this);
            }
        }
    }
    private void setNewLoc() {

        Random ran = new Random();

        int newX = ran.nextInt(GameSetting.WIDTH - 200) + 100;
        int newY = ran.nextInt(GameSetting.HEIGHT - 200) + 100;

        this.getModel().setX(newX);
        this.getModel().setY(newY);
    }


    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller || other instanceof Helper) {
            this.getModel().setX(10000);
            this.getModel().setY(10000);
            StarController.instance.setAliveDiamon(false);

        }
        if (other instanceof TrapController || other instanceof EnemyPlane) {
            setNewLoc();
        }
    }
}
