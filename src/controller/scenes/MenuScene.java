package controller.scenes;

import controller.GameSetting;
import controller.Planecontroller;
import controller.scenes.icon.Mute;
import controller.scenes.icon.Start;
import util.Utils;
import view.Animation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by quyet on 12/28/2016.
 */
public class MenuScene extends GameScene {
    private static final int MUTE_X = GameSetting.WIDTH * 1/15;
    private static final int MUTE_Y = GameSetting.HEIGHT * 13/15;
    private static final int START_X = GameSetting.WIDTH/2 - Start.WIDTH/2 ;
    private static final int START_Y = GameSetting.HEIGHT * 2/3;
    BufferedImage background ;
    private Start start;
    Mute mute;
    public MenuScene(){
        start = new Start(START_X, START_Y);
        mute= new Mute(MUTE_X, MUTE_Y);

        background = Utils.loadImage("resources/background/background.png");
        Planecontroller.instance.getModel().setX(GameSetting.WIDTH/2 - Planecontroller.instance.getModel().getWidth()/2);
        Planecontroller.instance.getModel().setY(GameSetting.HEIGHT * 1/3);
    }
    @Override
    public void update(Graphics graphics) {

        Font font = new Font("Bauhaus 93", Font.BOLD, 50);
        graphics.setFont(font);
        graphics.setColor(Color.red);

        graphics.drawImage(Utils.loadImage("resources/background/GameStart.png"),0,0, GameSetting.WIDTH,GameSetting.HEIGHT,null);
        graphics.drawImage(background,0,0, GameSetting.WIDTH,GameSetting.HEIGHT,null);
        Planecontroller.instance.draw(graphics);

//        graphics.drawString("Press SPACE to play" , 130, 350);
        start.update(graphics);
        mute.update(graphics);



    }

    @Override
    public void run() {
        start.checkMouse();
        mute.checkMouse();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (start.checkMouse()) {
            this.sceneListener.replaceScene(new PlayGameScene(), true);
        }
        if (mute.checkMouse() && !Mute.sttmute)
        {
            System.out.println("tat");
            mute.mouseClicked(mouseEvent);
            Utils.clip.stop();
        }else {
            System.out.printf("mo");
            mute.mouseClicked(mouseEvent);
            Utils.clip.start();
        }


    }
    @Override
    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_SPACE)
//        this.sceneListener.replaceScene(
//                new PlayGameScene(),
//                true
//
//        );
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
