package controller.trap;

import controller.GameVector;
import controller.Planecontroller;
import controller.managers.ControllerManager;


/**
 * Created by apple on 12/24/16.
 */
public class ShootOnTargetBehavior implements ShootBehavior {

    private final int SPEED = 5;

    @Override
    public void doShot(EnemyPlane enemyController) {
        double x = enemyController.getModel().getMidX();
        double y = enemyController.getModel().getBottom();
        Planecontroller planeController = Planecontroller.instance;

        GameVector dVector = planeController.getModel().subtract(enemyController.getModel());
        double length = dVector.getLength();

        double steps = length / (double)SPEED;
        GameVector bulletMoveVector = new GameVector((int)(dVector.dx / steps), (int)(dVector.dy / steps));



        EnemyBullet enemyBullet =
                EnemyBullet.create((int)x, (int)y, bulletMoveVector);

        ControllerManager.controllers.add(enemyBullet);
    }
}
