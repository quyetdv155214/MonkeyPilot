package controller.managers;

import controller.BaseController;
import controller.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by q on 12/17/2016.
 */
public class ControllerManager implements BaseController {
    public static Vector<Controller> controllers;


    public static final ControllerManager explosion = new ControllerManager();
    public static final ControllerManager instance = new ControllerManager();


    public ControllerManager() {
        controllers = new Vector<>();
    }


    public void draw(Graphics g) {
        try {
            for (Controller controller : this.controllers) {
                controller.draw(g);
            }
        } catch (Exception e) {

        }
    }

    int count = 0;
    int slowTime = 0;
    public static int slow = 0;

    public void run() {
        if (slowTime ==100 ){
            slow = 0;
            count=0;
            slowTime =0;
        }
        if (count == slow) {
            for (int i = 0; i < controllers.size(); i++) {
                controllers.get(i).run();
            }
            count = 0;
            slowTime++;
        }
        if (count < slow) {
            count++;
        }
        System.out.println(count);


        Iterator<Controller> iterator = this.controllers.iterator();


        while (iterator.hasNext()) {

            Controller controller = iterator.next();

            if (controller.getModel().checkDead()) {
                iterator.remove();
            }
        }

    }

}
