package controller.trap;

import controller.GameVector;
import controller.Planecontroller;
import model.Model;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class Explosion implements AttackBehavior {
    @Override
    public void doAttack(Object o) {
       Model m =  (Model) o;
        GameVector subtract = m.subtract(Planecontroller.instance.getModel());
        double length = subtract.getLength();
        System.out.println(length);
        if (length < 200){
            m.destroy();
            Planecontroller.instance.getMoveVector().reverse();
        }
    }
}
