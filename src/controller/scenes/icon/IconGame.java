package controller.scenes.icon;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by quyet on 1/2/2016.
 */
public interface IconGame {
    void update(Graphics g);
    boolean checkMouse();
    void mouseClicked(MouseEvent e);
}
