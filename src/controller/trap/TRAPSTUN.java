package controller.trap;

import controller.Controller;
import controller.Planecontroller;
import model.Model;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class TRAPSTUN implements AttackBehavior {
    private int timeCounter =0;
    @Override
    public void doAttack(Controller controller) {
        Model m =controller.getModel();
        m.destroy();
      Planecontroller.instance.setMove(false);
    }
}
