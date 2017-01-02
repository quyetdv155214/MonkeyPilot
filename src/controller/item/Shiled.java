package controller.item;

import controller.Body;
import controller.Controller;
import controller.Planecontroller;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.Animation;
import view.SingleView;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Dell on 01/01/2017.
 */
public class Shiled extends Controller implements Body {
    private final int WIDTH = 120;
    private final int HEIGHT = 120;

    public Shiled(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    @Override
    public void run() {
        if (model.isAlive()) {
            super.run();
            model.setX((int) Planecontroller.instance.getModel().getX() - (WIDTH - Planecontroller.instance.getModel().getWidth()) / 2);
            model.setY((int) Planecontroller.instance.getModel().getY() - (HEIGHT - Planecontroller.instance.getModel().getHeight()) / 2);
            model.decGas();
        }

    }

    public static final Shiled instance = create();

    @Override
    public void draw(Graphics g) {
        if (model.isAlive())
            super.draw(g);
    }

    private static Shiled create() {
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/shield/shield1.png"));
        images.add(Utils.loadImage("resources/shield/shield2.png"));
        images.add(Utils.loadImage("resources/shield/shield3.png"));
        images.add(Utils.loadImage("resources/shield/shield4.png"));
        images.add(Utils.loadImage("resources/shield/shield5.png"));
//        images.add(Utils.loadImage("resources/shield/shield6.png"));
        images.add(Utils.loadImage("resources/shield/shield7.png"));
        images.add(Utils.loadImage("resources/shield/shield8.png"));
        images.add(Utils.loadImage("resources/shield/shield9.png"));
        Shiled f = new Shiled(
                new Model(Planecontroller.instance.getModel().getX()
                        , Planecontroller.instance.getModel().getY() - Planecontroller.instance.getModel().getHeight(),
                        120, 120),
                new Animation(images));
        f.getModel().setLiveTime(10);
        return f;
    }


    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller || other instanceof Helper) {
            this.getModel().setAlive(false);
        }
    }
}
