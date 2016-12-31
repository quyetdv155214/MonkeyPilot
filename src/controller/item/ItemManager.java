package controller.item;

import controller.GameSetting;
import controller.managers.ControllerManager;

import java.util.Random;

/**
 * Created by quyet on 12/27/2016.
 */
public class ItemManager extends ControllerManager {


    public static final int XX = 1000;
    @Override
    public void run() {
        super.run();
        addItem();
    }

    public void addItem() {

        Random ran = new Random();
        int x = ran.nextInt(GameSetting.instance.getWidth() -110) + 100;
        int y = 0;
        int type = ran.nextInt(XX);
        switch (type) {
            case 1:
                controllers.add(BulletItem.create(x, y));
                break;
            case 2:
                controllers.add(Time.create(x, y));
                break;
            case 3:
                controllers.add(ShieldItem.create(x, y));
                break;
            case 4:
                controllers.add(IceItem.creat(x,y));
                break;
            default:
                return;
        }

    }

}
