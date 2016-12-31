package controller.managers;

import controller.GameSetting;
import controller.trap.EnemyPlane;

import java.awt.*;
import java.util.Random;

/**
 * Created by quyet on 12/27/2016.
 */
public class EnemyPlaneManager extends  ControllerManager {

    int timecount = 0;

    public void spawn() {
        timecount++;
        Random ran = new Random();
        int x = ran.nextInt(GameSetting.instance.getWidth()-200) + 100;
        int y = 0;
        if (timecount == 500) {
            controllers.add(EnemyPlane.create(x,y));
            timecount = 0;

        }
    }
    public void run(){
        super.run();
        spawn();
    }
    public void draw(Graphics g) {
        super.draw(g);
    }
}