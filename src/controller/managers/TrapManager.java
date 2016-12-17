package controller.managers;

import controller.Planecontroller;
import controller.TrapController;

import java.awt.*;
import java.util.Vector;

/**
 * Created by q on 12/17/2016.
 */
public class TrapManager extends ControllerManager {

    public void create(){
       TrapController trapController = TrapController.create();
    }



    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void run() {
        super.run();

    }
}
