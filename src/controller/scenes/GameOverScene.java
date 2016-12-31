package controller.scenes;

import controller.GameSetting;
import controller.GameVector;
import controller.Planecontroller;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by PT-LS on 1/1/2017.
 */
public class GameOverScene extends GameScene {
    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(Utils.loadImage("resources/gameOver.png"), 0 , 0 ,
                GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
        Font font = new Font("Bauhaus 93", Font.BOLD, 50);
        graphics.setFont(font);
        graphics.setColor(Color.RED);
        graphics.drawString("Score: "+ Planecontroller.instance.getScore() ,
                GameSetting.instance.getWidth()/2-80, GameSetting.instance.getHeight()-80);

    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new PlayGameScene(), true);
//        Planecontroller.instance.getModel().setAlive(true);
//        Planecontroller.instance.getModel().setX(300);
//        Planecontroller.instance.getModel().setY(300);
//        Planecontroller.instance.getModel().setHp(3);
//        Planecontroller.instance.getModel().setLiveTime(100);
//        Planecontroller.instance.setScore(0);
//        Planecontroller.instance.setMoveVector(new GameVector());
    Planecontroller.instance.reset();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
