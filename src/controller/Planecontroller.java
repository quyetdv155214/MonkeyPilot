package controller;

import model.Model;
import util.Utils;
import view.View;

/**
 * Created by Dell on 17/12/2016.
 */
public class Planecontroller extends Controller {
    private static final int width = 50;
    private static final int height = 30;

    public Planecontroller(Model model, View view) {
        super(model, view);
    }

    public static Planecontroller creat(int x, int y) {
        return new Planecontroller(new Model(x, y, width, height), new View(Utils.loadimage("resources/plane2.png")));
    }

    public static int deg = 0;

    public void run() {
        double x;
        double y;

        deg++;

        double raDeg = Math.toRadians(deg);
        x = 2 * Math.sin(raDeg);
        y = 2 * Math.cos(raDeg);

        if (deg == 360) {
            deg = -1;
        }
        this.model.move(x, y);
    }

}
