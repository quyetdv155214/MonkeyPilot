package controller.trap;

/**
 * Created by Duc Duong on 1/1/2017.
 */
public class MoveInLine implements EnemyMoveBehavior {
    private int speed =1 ;
    @Override
    public void doMove(EnemyPlane enemyPlane) {
            enemyPlane.getModel().move(speed, 0);
    }
}
