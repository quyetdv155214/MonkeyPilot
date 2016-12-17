package controller;

import controller.managers.ControllerManager;
import controller.managers.TrapManager;
import model.Model;
import util.Utils;
import view.View;
import controller.managers.BodyManager;

import java.util.TreeMap;

/**
 * Created by Dell on 17/12/2016.
 */

public class Planecontroller extends Controller implements Body {
    private static final int width = 50;
    private static final int height = 30;
    private int score = 0;
    private double speed = 1;


    public Planecontroller(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }


    private int n = 0;
    double x;
    double y;


    public static Planecontroller creat(int x, int y) {
        Planecontroller planecontroller = new Planecontroller(new Model(x, y, width, height), new View(Utils.loadimage("resources/plane2.png")));
        planecontroller.getModel().setHp(3);
        return planecontroller;
    }

    public static int deg = 88;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getScore() {
        return score;
    }

    public void run() {
        if (this.getModel().isAlive())
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
                }
                this.model.move(x, y);
            } else {
                if (this.model.checkout()) {
                    x = -x;
                    y = -y;
                }
                this.model.move(x, y);
            }
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Starcontroller) {
            score++;
            ControllerManager.controllers.add(TrapController.create());
        }
        if (other instanceof TrapController) {
            this.getModel().decHp(1);
        }
    }
}
