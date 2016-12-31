package controller.scenes;

import controller.GameSetting;
import controller.Planecontroller;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by quyet on 12/28/2016.
 */
public class MenuScene extends GameScene {
    public MenuScene(){

    }
    @Override
    public void update(Graphics graphics) {
        Font font = new Font("Bauhaus 93", Font.BOLD, 20);
        graphics.setFont(font);
        graphics.setColor(Color.pink);
        graphics.drawImage(Utils.loadImage("resources/GameStart.png"),0,0, GameSetting.instance.getWidth(),GameSetting.instance.getHeight(),null);
        graphics.drawString("Press any key to play " , 300, 300);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(
                new PlayGameScene(),
                false

        );
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
