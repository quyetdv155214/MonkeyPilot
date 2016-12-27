package controller.managers;

import controller.BaseController;
import controller.trap.TrapController;

import java.awt.*;

/**
 * Created by q on 12/17/2016.
 */
public class TrapManager extends ControllerManager{


    public void create(){
        TrapController trapController = TrapController.create();
        controllers.add(trapController);
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
