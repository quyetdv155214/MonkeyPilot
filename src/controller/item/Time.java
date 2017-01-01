package controller.item;

import controller.Body;
import controller.Controller;
import controller.GameVector;
import controller.Planecontroller;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by quyet on 12/27/2016.
 */
public class Time extends Controller implements Body {
    public static final int WIDTH =50;
    public static final int HEIGHT =50;
    int time = 0;
    GameVector moveVector;
    public Time(Model model, View view, GameVector moveVector) {
        super(model, view);
        this.moveVector = moveVector;
        BodyManager.instance.register(this);

    }

    public Time(Model model, View view) {
        super(model, view);
        this.moveVector = new GameVector(0, 1);
        BodyManager.instance.register(this);

    }

    @Override
    public void run() {
        super.run();
        time ++;
        if (time ==3 ){

            model.move(moveVector);
            time=0;
        }
    }

    public static Time create(int x, int y){
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/gas_edit.png"));
        Time b = new Time(
                new Model(x, y,WIDTH, HEIGHT ),
                new Animation(images)
        );
        return b;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller)
        {
            this.getModel().setAlive(false);
            Controller.playsound("resources/Anqua.wav",false,Controller.sound);
        }
    }
}
