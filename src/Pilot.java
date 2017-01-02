import controller.Controller;
import controller.GameSetting;
import controller.Planecontroller;
import controller.scenes.GameScene;
import controller.scenes.MenuScene;
import controller.scenes.PlayGameScene;
import controller.scenes.SceneListener;
import util.IO;
import util.Utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Stack;

/**
 * Created by Dell on 17/12/2016.
 */
public class Pilot extends Frame implements Runnable, SceneListener {
    BufferedImage backbuffer;
    GameScene currenScene;
    Stack<GameScene> gameSceneStack;
    boolean stop = false;

    public Pilot() throws IOException {
        setSize(GameSetting.WIDTH, GameSetting.HEIGHT);
        setVisible(true);
        gameSceneStack = new Stack<>();
        Utils.playSound2("resources/sound/play/music.wav",true);

        this.replaceScene(
                new MenuScene(),
                false
        );

        backbuffer = new BufferedImage(GameSetting.WIDTH, GameSetting.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currenScene.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
//                IO.saveGame();
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println("keyPressed");
                currenScene.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    if (GameScene.running)
                        GameScene.running = false;
                    else GameScene.running = true;
                    if (!GameScene.running) Utils.clip.stop();
                    else if (Controller.sound) Utils.clip.start();
                }else
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    if (GameSetting.sleepTime > 2)
                        GameSetting.sleepTime --;
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    GameSetting.sleepTime++;
                }
                else if
                        (e.getKeyCode() == KeyEvent.VK_R)
                {
                    replaceScene(new PlayGameScene(), false);
                    Planecontroller.instance.reset();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("keyReleased");
                currenScene.keyReleased(e);
            }
        });
        setResizable(false);
    }


    private void init() {

    }

    public void replaceScene(GameScene newScene, boolean addToBackStack) {
        if (addToBackStack && currenScene != null) {
            gameSceneStack.add(currenScene);

        }
        currenScene = newScene;
        currenScene.setSceneListener(this);

    }

    @Override
    public void back() {

    }

    public void update(Graphics g) {
        Graphics bbg = backbuffer.getGraphics();
        if (GameScene.running)
            currenScene.update(bbg);

        g.drawImage(backbuffer, 0, 0, GameSetting.WIDTH, GameSetting.HEIGHT, null);
        g.setColor(Color.RED);
        g.drawString((1000/ GameSetting.sleepTime) + " FPS" , GameSetting.WIDTH - 100, 60 );

    }


    public void run() {
        while (true) {
            try {

                Thread.sleep(GameSetting.sleepTime);
                this.repaint();
                if (GameScene.running)
                    currenScene.run();
                Point point = this.getLocation();

                Utils.getLocation(MouseInfo.getPointerInfo().getLocation().x - (int) point.getX(),
                        MouseInfo.getPointerInfo().getLocation().y - (int) point.getY());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
