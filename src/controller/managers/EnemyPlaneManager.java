package controller.managers;

import controller.GameSetting;
import controller.trap.EnemyPlane;
import controller.trap.EnemyType;

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
        if (timecount == 400) {
            int i = ran.nextInt(3);
            switch (i)
            {
                case 0:
                controllers.add(EnemyPlane.create(x,y, EnemyType.GASDEC));
                    break;
                case 1:
                    x =0;
                    y = ran.nextInt(GameSetting.instance.getHeight()-200) + 100;
//                    y= 300;
                    controllers.add(EnemyPlane.create(x,y, EnemyType.LIFEDEC));
                    break;
                case 2:
//                    x= 300;
                    controllers.add(EnemyPlane.create(x,y, EnemyType.EXPLOSION));
                    break;
            }
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