package controller;

import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import model.Model;
import util.Utils;
import view.View;

import java.awt.*;
import java.util.Random;

/**
 * Created by q on 12/17/2016.
 */
public class TrapController extends Controller implements Body{
    private static final int width = 50;
    private static final int height = 30;

    public TrapController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    public static TrapController create(){
        Random ran = new Random();
        int x= ran.nextInt(400) + 100;
        int y  = ran.nextInt(600) + 100;
        TrapController trapController = new TrapController(new Model(x, y, width,height),
                new View(Utils.loadimage("resources/bomb.png")));
        trapController.getModel().setHp(1);
        return trapController;

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void run() {
//        if(!this.getModel().isAlive()){
//            ControllerManager.controllers.remove(this);
//            System.out.println("remove controller");
//
//        }


    }

    @Override
    public void onContact(Body other) {
        this.getModel().decHp(1);
        System.out.println("bomb hp = " + this.getModel().getHp());
        BodyManager.instance.remove(this);

    }
}
