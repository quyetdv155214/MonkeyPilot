package controller.scenes.icon;

import controller.scenes.GameScene;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static util.Utils.loadImage;

/**
 * Created by quyet on 1/2/2017.
 */
public class Mute extends GameScene implements IconGame {

    private Image mute;
    private int x;
    private int y;
   public static boolean sttmute;

    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    public Mute(int x, int y) {
        this.x = x;
        this.y = y;
        mute = loadImage("resources/icon/mute/mute2.png");
        sttmute= false;

    }

    @Override
    public void update(Graphics g) {
        g.drawImage(mute, x, y, WIDTH, HEIGHT, null);
    }

    @Override
    public void run() {

    }

    @Override
    public boolean checkMouse() {
        if (Utils.point.getX() >= x
                && Utils.point.getX() <= x + WIDTH
                && Utils.point.getY() <= y + HEIGHT
                && Utils.point.getY() >= y) {

            return true;
        }
        return false;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!sttmute){
            mute = loadImage("resources/icon/mute/mute1.png");
            sttmute = true;
        }
        else {
            mute = loadImage("resources/icon/mute/mute2.png");
            sttmute = false;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
