package controller.trap;

import controller.Planecontroller;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class LifeDec implements AttackBehavior {
    @Override
    public void doAttack(Object o) {
        Planecontroller.instance.getModel().decHp(1);
        Planecontroller.instance.getMoveVector().reverse();
    }
}
