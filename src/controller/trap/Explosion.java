package controller.trap;

import controller.Controller;
import controller.GameVector;
import controller.Planecontroller;
import model.Model;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class Explosion implements AttackBehavior {
    @Override
    public void doAttack(Controller controller) {
       Model m =  controller.getModel();
        GameVector subtract = m.subtract(Planecontroller.instance.getModel());
        double length = subtract.getLength();
       // System.out.println(length);
        if (length < 100){
            m.destroy();
            Planecontroller.instance.getMoveVector().reverse();
        }
    }
}
