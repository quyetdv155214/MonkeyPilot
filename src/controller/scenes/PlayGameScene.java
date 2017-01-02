package controller.scenes;


import controller.*;
import controller.item.Shiled;
import controller.item.Helper;
import controller.item.ItemManager;
import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import controller.managers.EnemyPlaneManager;
import controller.managers.MeteoManager;
import model.BackGround;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by quyet on 12/28/2016.
 */
public class PlayGameScene extends GameScene {


    Image background;
    private static BackGround bg1, bg2;
    Vector<BaseController> baseControllers;
    private BufferedImage tip;

    public PlayGameScene() {
        baseControllers = new Vector<>();
        baseControllers.add(new MeteoManager());
        baseControllers.add(ControllerManager.explosion);
        baseControllers.add(ControllerManager.instance);
        baseControllers.add(new ControllerManager());
        baseControllers.add(StarController.instance);
        baseControllers.add(Planecontroller.instance);
        baseControllers.add(BodyManager.instance);
        baseControllers.add(new ItemManager());
        baseControllers.add(new EnemyPlaneManager());
        baseControllers.add(Shiled.instance);
        baseControllers.add(Helper.instance);
        background = Utils.loadImage("resources/background/background1.png");
        bg1 = new BackGround(0, 0);
        bg2 = new BackGround(2300, 0);
//        tip = Utils.loadImage("resources/background/background/background1.png");



    }

    @Override
    public void update(Graphics bbg) {
        bbg.drawImage(background, bg1.getBgX(), bg1.getBgY(), 2300, GameSetting.HEIGHT, null);
        bbg.drawImage(background, bg2.getBgX(), bg2.getBgY(), 2300, GameSetting.WIDTH, null);

        if (Planecontroller.instance.getModel().isAlive()) {
            for (BaseController b : this.baseControllers) {
                b.draw(bbg);
            }
            Font font = new Font("Bauhaus 93", Font.BOLD, 25);
            bbg.setFont(font);
            bbg.setColor(Color.RED);

            bbg.drawString("HP : " + Planecontroller.instance.getModel().getHp(), 100, 100);
            bbg.drawString("Score : " + Planecontroller.instance.getScore(), 100, 130);
            Planecontroller.instance.getModel().drawHealthBar(bbg, 100, 160);
            bbg.drawImage(tip, 0, 0, GameSetting.WIDTH, GameSetting.HEIGHT, null);
        }


    }

    @Override
    public void run() {

        for (BaseController b : baseControllers) {
            b.run();
        }
        //
        bg1.update();
        bg2.update();
        if (!Planecontroller.instance.getModel().isAlive()) {
            this.sceneListener.replaceScene(
                    new GameOverScene(),
                    true

            );
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Planecontroller.instance.setTurn(1);
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            if (!Controller.sound) {
                if (GameScene.running){
                    Controller.sound = true;
                    Utils.clip.start();
                }

            }
            else {
                if (GameScene.running)
                Controller.sound = false;
                Utils.clip.stop();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Planecontroller.instance.setTurn(0);
    }
}
