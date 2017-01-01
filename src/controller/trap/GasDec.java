package controller.trap;

import controller.Controller;
import controller.Planecontroller;
import model.Model;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class GasDec implements AttackBehavior {


    @Override
    public void doAttack(Controller controller) {
        Planecontroller.instance.getModel().icsGas(-15);
        Model m =controller.getModel();
        m.destroy();
    }
}
