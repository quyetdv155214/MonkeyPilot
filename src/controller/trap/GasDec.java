package controller.trap;

import controller.Planecontroller;
import model.Model;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class GasDec implements AttackBehavior {


    @Override
    public void doAttack(Object o) {

        Planecontroller.instance.getModel().icsGas(-15);
    }
}
