package controller.scenes;

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

    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(
                new PlayGameScene(),
                true

        );
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
