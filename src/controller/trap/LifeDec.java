package controller.trap;

import controller.Body;
import controller.Controller;
import controller.Planecontroller;
import controller.managers.BodyManager;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class LifeDec implements AttackBehavior {
    @Override
    public void doAttack(Controller controller) {
        Planecontroller.instance.getModel().decHp(1);
        Planecontroller.instance.getMoveVector().reverse();
        Controller.playsound("resources/sound/play/wall.wav",false,Controller.sound);
        BodyManager.instance.remove((Body)controller);
    }
}
