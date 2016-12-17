package controller;

import controller.managers.BodyManager;
import model.Model;
import view.View;

import java.util.Random;

/**
 * Created by Dell on 17/12/2016.
 */
public class Starcontroller extends Controller implements Body{

    public Starcontroller(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller) {
            Random ran = new Random();
            int newX= ran.nextInt(600) + 100;
            int newY  = ran.nextInt(400) + 100;
            this.getModel().setX(newX);
            this.getModel().setY(newY);
        }
    }
}
