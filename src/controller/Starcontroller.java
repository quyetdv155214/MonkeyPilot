package controller;

import controller.managers.BodyManager;
import controller.trap.TrapController;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

import java.util.Random;

/**
 * Created by Dell on 17/12/2016.
 */
public class Starcontroller extends Controller implements Body {

    private static int count = 0;
    private boolean isAliveDiamon = true;

    public boolean getAliveDiamon() {
        return isAliveDiamon;
    }

    public void setAliveDiamon(boolean aliveDiamon) {
        isAliveDiamon = aliveDiamon;
    }
    public Starcontroller(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public static Starcontroller instance = create(200, 200);

    private static Starcontroller create(int x, int y) {
        Starcontroller starcontroller = new Starcontroller(
                new Model(x, y, 50, 50),
                new SingleView(Utils.loadImage("resources/diamond.png"))
        );
        return starcontroller;
    }

    @Override
    public void run() {
        super.run();
        if (!Starcontroller.instance.getAliveDiamon()){
            count++;
            if (count > 500){
                count = 0;
                setNewLoc();
                Starcontroller.instance.setAliveDiamon(true);
                BodyManager.instance.register(this);
            }
        }
    }
    private void setNewLoc() {

        Random ran = new Random();

        int newX = ran.nextInt(GameSetting.instance.getWidth() - 200) + 100;
        int newY = ran.nextInt(GameSetting.instance.getHeight() - 200) + 100;

        this.getModel().setX(newX);
        this.getModel().setY(newY);
    }


    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller) {
            this.getModel().setX(1000);
            this.getModel().setY(1000);
            Starcontroller.instance.setAliveDiamon(false);

        }
        if (other instanceof TrapController) {
            setNewLoc();
        }
    }
}
