package controller.scenes;


import controller.BaseController;
import controller.GameSetting;
import controller.Planecontroller;
import controller.Starcontroller;
import controller.item.ItemManager;
import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import controller.managers.EnemyPlaneManager;
import controller.managers.MeteoManager;
import model.BackGround;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * Created by quyet on 12/28/2016.
 */
public class PlayGameScene extends GameScene {


    Image background;
    private static BackGround bg1, bg2;
    Vector<BaseController> baseControllers;

    public PlayGameScene() {
        baseControllers = new Vector<>();
        baseControllers.add(new MeteoManager());
        baseControllers.add(ControllerManager.explosion);
        baseControllers.add(new ControllerManager());
        baseControllers.add(Starcontroller.instance);
        baseControllers.add(Planecontroller.instance);
        baseControllers.add(BodyManager.instance);
        baseControllers.add(new ItemManager());
baseControllers.add(new EnemyPlaneManager());

        background = Utils.loadImage("resources/background1.png");
        bg1 = new BackGround(0, 0);
        bg2 = new BackGround(2300, 0);


    }


    @Override
    public void update(Graphics bbg) {
        bbg.drawImage(background, bg1.getBgX(), bg1.getBgY(), 2300, GameSetting.instance.getHeight(), null);
        bbg.drawImage(background, bg2.getBgX(), bg2.getBgY(), 2300, GameSetting.instance.getHeight(), null);

            if (Planecontroller.instance.getModel().isAlive()) {
            for (BaseController b : this.baseControllers) {
                b.draw(bbg);
            }
            Font font = new Font("Bauhaus 93", Font.BOLD, 20);
            bbg.setFont(font);
            bbg.drawString("HP : " + Planecontroller.instance.getModel().getHp(), 100, 100);
            bbg.drawString("Score : " + Planecontroller.instance.getScore(), 100, 120);
            Planecontroller.instance.getModel().drawHealthBar(bbg, 100, 140);
        }
//        else {
//            bbg.drawImage(Utils.loadImage("resources/gameOver.png"), 0, 0,
//                    GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
//
//        }

    }

    @Override
    public void run() {

        for (BaseController b : baseControllers) {
            b.run();
        }
        //
        bg1.update();
        bg2.update();
        if (!Planecontroller.instance.getModel().isAlive()){
            this.sceneListener.replaceScene(
                    new GameOverScene(),
                    true

            );
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
            Planecontroller.instance.setN(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Planecontroller.instance.setN(0);
    }
}
