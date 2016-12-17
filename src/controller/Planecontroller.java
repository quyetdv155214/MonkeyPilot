package controller;

import model.Model;
import util.Utils;
import view.View;
import controller.managers.BodyManager;

/**
 * Created by Dell on 17/12/2016.
 */

public class Planecontroller extends Controller implements Body {
    private static final int width = 50;
    private static final int height = 30;

    public Planecontroller(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }


    private int n = 0;
    double x;
    double y;


    public static Planecontroller creat(int x, int y) {
        return new Planecontroller(new Model(x, y, width, height), new View(Utils.loadimage("resources/plane2.png")));
    }

    public static int deg = 88;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void run() {

        if (n == 1) {
            deg++;
            double raDeg = Math.toRadians(deg);
            x = 2 * Math.sin(raDeg);
            y = 2 * Math.cos(raDeg);

            if (deg == 360) {
                deg = -1;
            }
            this.model.move(x, y);
        } else this.model.move(x, y);
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Starcontroller){
            System.out.println("Da va cham -------------------");

        }
    }
}
