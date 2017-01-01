package controller.item;

import controller.*;
import controller.managers.BodyManager;
import controller.trap.TrapController;
import model.Model;
import util.Utils;
import view.Animation;
import view.SingleView;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by quyet on 1/1/2017.
 */
public class Helper extends Controller implements Body {
    public Helper(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    private static final int width = 70;
    private static final int height = 30;
    @Override
    public void run() {
        if (model.isAlive()) {

            super.run();
            model.setX((int) Planecontroller.instance.getModel().getX() + Planecontroller.instance.getModel().getWidth());
            model.setY((int) Planecontroller.instance.getModel().getY() );
            model.decGas();

        }
    }

    public static final Helper instance = create();


    @Override
    public void draw(Graphics g) {
        if (model.isAlive())
            super.draw(g);
    }

    private static Helper create() {
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/heli1.png"));
        images.add(Utils.loadImage("resources/heli2.png"));

        Helper f = new Helper(
                new Model(Planecontroller.instance.getModel().getX() + Planecontroller.instance.getModel().getWidth()
                        , Planecontroller.instance.getModel().getY(),
                        width, height),
                new Animation(images));

        f.getModel().setLiveTime(0);

        return f;
    }


    @Override
    public void onContact(Body other) {
        if (other instanceof Starcontroller)
        {
            Controller.playsound("resources/Anqua.wav",false,Controller.sound);
            Planecontroller.instance.icsScore();
        }
        if (other instanceof Meteo) {
            Planecontroller.instance.getModel().decHp(1);
            Controller.playsound("resources/Vacham.wav",false,Controller.sound);
        }
        if (other instanceof TrapController) {
            Planecontroller.instance.getModel().decHp(1);
            Controller.playsound("resources/Vacham.wav",false,Controller.sound);
        }
        if (other instanceof Time) {
            Planecontroller.instance.getModel().icsGas(15);
            Controller.playsound("resources/Anqua.wav",false,Controller.sound);
        }
        if (other instanceof ShieldItem) {
            Controller.playsound("resources/Anqua.wav",false,Controller.sound);
            FireCircle.instance.getModel().setAlive(true);
            FireCircle.instance.getModel().setLiveTime(5);


        }
        if (other instanceof BulletItem) {
//            this.getModel().icsGas(15);


        }


    }
}
