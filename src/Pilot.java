import controller.Controller;
import controller.GameSetting;
import controller.Planecontroller;
import controller.scenes.GameScene;
import controller.scenes.MenuScene;
import controller.scenes.PlayGameScene;
import controller.scenes.SceneListener;
import util.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

/**
 * Created by Dell on 17/12/2016.
 */
public class Pilot extends Frame implements Runnable, SceneListener {
    BufferedImage backbuffer;
    GameScene currenScene;
    Stack<GameScene> gameSceneStack;
    int sleepTime = 17;

    public Pilot() {
        setSize(GameSetting.instance.getWidth(), GameSetting.instance.getHeight());
        setVisible(true);
        gameSceneStack = new Stack<>();
        Utils.playSound2("resources/BoomOnline-Dangcapnhat_8t5h.wav",true);

        this.replaceScene(
                new MenuScene(),
                false
        );

        backbuffer = new BufferedImage(GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), BufferedImage.TYPE_INT_ARGB);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
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
                    if (sleepTime > 2)
                        sleepTime --;
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    sleepTime++;
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

        g.drawImage(backbuffer, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
        g.setColor(Color.RED);
        g.drawString((1000/ sleepTime) + " FPS" , GameSetting.instance.getWidth() - 100, 60 );

    }
    public void run() {
        while (true) {
            try {

                Thread.sleep(sleepTime);
                this.repaint();
                if (GameScene.running)
                    currenScene.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
