package controller.item;

import controller.Body;
import controller.Controller;
import controller.Planecontroller;
import controller.managers.BodyManager;
import controller.trap.EnemyPlane;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

import javax.rmi.CORBA.Util;
import java.awt.*;

/**
 * Created by Dell on 01/01/2017.
 */
public class FireCircle extends Controller implements Body {
    public FireCircle(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }


    @Override
    public void run() {
        if (model.isAlive()) {
            super.run();
            model.setX((int) Planecontroller.instance.getModel().getX() - 30);
            model.setY((int) Planecontroller.instance.getModel().getY() - Planecontroller.instance.getModel().getHeight() - 10);
            model.decGas();
        }
    }

    public static final FireCircle instance = create();

    @Override
    public void draw(Graphics g) {
        if (model.isAlive())
        super.draw(g);
    }

    private static FireCircle create() {
        FireCircle f = new FireCircle(
                new Model(Planecontroller.instance.getModel().getX()
                        , Planecontroller.instance.getModel().getY() - Planecontroller.instance.getModel().getHeight(),
                        120, 120),
                new SingleView(Utils.loadImage("resources/Firecircle.png")));
        f.getModel().setLiveTime(5);
        return f;
    }


    @Override
    public void onContact(Body other) {

    }
}
