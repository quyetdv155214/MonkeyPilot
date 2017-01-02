package controller.trap;

import controller.GameSetting;
import controller.GameVector;

/**
 * Created by quyet on 12/27/2016.
 */
public class MoveFollowY implements EnemyMoveBehavior {


    GameVector moveVector;

    @Override
    public void doMove(EnemyPlane enemyPlane) {
//        moveVector = enemyPlane.moveVector;
        if (enemyPlane.getModel().getX() > GameSetting.WIDTH-enemyPlane.getModel().getWidth()){
            enemyPlane.getModel().move(moveVector);
        }


    }
}
