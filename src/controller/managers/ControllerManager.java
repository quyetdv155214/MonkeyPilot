package controller.managers;

import controller.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by q on 12/17/2016.
 */
public class ControllerManager {
    public static Vector<Controller> controllers;

    public ControllerManager() {
        controllers = new Vector<>();
    }

    public void draw(Graphics g) {
        try {
            for(Controller controller : this.controllers) {
                controller.draw(g);
            }
        }catch (Exception e){

        }
    }

    public void run() {
        for(Controller controller: this.controllers) {
            controller.run();
        }
        Iterator<Controller> iterator = this.controllers.iterator();
        // remove
//        System.out.println("run");

        while(iterator.hasNext()){
            //
            Controller controller = iterator.next();
            //
            if(!controller.getModel().isAlive()){
                iterator.remove();
//                System.out.println("remove controller");
            }
        }
    }

}
