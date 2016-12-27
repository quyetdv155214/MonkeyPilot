package controller;

import controller.managers.ControllerManager;
import controller.managers.TrapManager;
import controller.trap.TrapController;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;
import controller.managers.BodyManager;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Dell on 17/12/2016.
 */

public class Planecontroller extends Controller implements Body {
    private static final int width = 70;
    private static final int height = 30;
    private int score = 0;
    private double speed = 2;
    TrapManager trapManager = new TrapManager();
    GameVector moveVector;
    public static final Planecontroller instance = creat(300,300);


    private Planecontroller(Model model, View view) {
        super(model, view);
        moveVector = new GameVector(speed, 0);
//        curGas = MAX_GAS;
        model.setHp(3);

        BodyManager.instance.register(this);
    }


    private static Planecontroller creat(int x, int y) {

        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/heli1.png"));
        images.add(Utils.loadImage("resources/heli2.png"));
        ;
        Planecontroller planecontroller = new Planecontroller(new Model(x, y, width, height),
                new Animation(images));
        //
        planecontroller.getModel().setMAX_TIME_LIVE(100);
        planecontroller.getModel().setLiveTime(100);
        return planecontroller;
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getScore() {
        return score;
    }

    public static int deg = 88;

    private int n = 0;
    double x;
    double y;

    public void run() {

        if (this.getModel().isAlive()) {
            model.decGas();
            if (n == 1) {
                deg++;
                double raDeg = Math.toRadians(deg);
                x = speed * Math.sin(raDeg);
                y = speed * Math.cos(raDeg);

                if (deg == 360) {
                    deg = -1;
                }
                if (this.model.checkout()) {
                    x = -x;
                    y = -y;
//                    deg += 180;
//                     raDeg = Math.toRadians(deg);
//
//                    x = speed * Math.sin(raDeg);
//                    y = speed * Math.cos(raDeg);
                }
                this.model.move(x, y);
            } else {
                if (this.model.checkout()) {
                    x = -x;
                    y = -y;
//                    deg += 180;
//                    double raDeg = Math.toRadians(deg);
//
//                    x = speed * Math.sin(raDeg);
//                    y = speed * Math.cos(raDeg);
                }
                this.model.move(x, y);
            }
        }
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Starcontroller) {
            score++;
//            ControllerManager.controllers.add(TrapController.create());
            trapManager.create();
        }
        if (other instanceof TrapController) {
            this.getModel().decHp(1);

        }
    }
}
