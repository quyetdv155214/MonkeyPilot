import controller.GameSetting;
import controller.scenes.GameScene;
import controller.scenes.MenuScene;
import controller.scenes.SceneListener;

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


    public Pilot() {
        setSize(GameSetting.instance.getWidth(), GameSetting.instance.getHeight());
        setVisible(true);
        gameSceneStack = new Stack<>();


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
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("keyReleased");
                currenScene.keyReleased(e);
            }
        });
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

    public void update(Graphics g) {
        Graphics bbg = backbuffer.getGraphics();
        currenScene.update(bbg);

        g.drawImage(backbuffer, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                this.repaint();

                currenScene.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
