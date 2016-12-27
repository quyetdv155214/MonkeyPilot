package controller;

import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.SingleView;
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
    public static Starcontroller instance = create(200, 200);
    private static Starcontroller create(int x, int y){
        Starcontroller starcontroller = new Starcontroller(
                new Model(x, y, 50, 50),
                new SingleView(Utils.loadImage("resources/diamond.png"))
        );
        return starcontroller;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller) {
            Random ran = new Random();
            int newX= ran.nextInt(600) + 100;
            int newY  = ran.nextInt(400) + 100;
            Utils.playSound("resources/Pickup_Coin13.wav", false);
            this.getModel().setX(newX);
            this.getModel().setY(newY);
        }
    }
}
