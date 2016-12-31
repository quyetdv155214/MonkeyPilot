package controller.trap;

/**
 * Created by Duc Duong on 12/31/2016.
 */
public class MoveStraight implements EnemyMoveBehavior {
    private int speed =1 ;
    @Override
    public void doMove(EnemyPlane enemyPlane) {
        enemyPlane.getModel().move(0, speed);
    }
}
