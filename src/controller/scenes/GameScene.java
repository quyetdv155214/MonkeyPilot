package controller.scenes;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by quyet on 12/28/2016.
 */
public abstract class GameScene {
    public  static boolean running = true;
    protected SceneListener sceneListener;
    public void setSceneListener(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }
    public abstract void update(Graphics graphics);

    public abstract void run();
    public abstract void mouseClicked(MouseEvent e);
    public abstract void keyPressed(KeyEvent e);
    public abstract void keyReleased(KeyEvent e);


}
