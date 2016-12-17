package controller;

import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.View;

import java.util.Random;

/**
 * Created by q on 12/17/2016.
 */
public class TrapController extends Controller implements Body {
    private static final int width = 50;
    private static final int height = 30;

    public TrapController(Model model, View view) {

        super(model, view);
        BodyManager.instance.register(this);
    }

    public TrapController createTrap(){
        Random random = new Random();
        int x = random.nextInt(500) + 100;
        int y =random.nextInt(400) + 100;
        TrapController trap =
                new TrapController(new Model(x, y, width, height),new View(Utils.loadimage("resources/bomb.png")));
        return trap;
    }

    @Override
    public void onContact(Body other) {
        System.out.println("dinh bay");
        this.getModel().decHp(1);
    }
}
