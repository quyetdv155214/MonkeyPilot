package view;

import model.Model;
import model.Model;

import java.awt.*;

/**
 * Created by apple on 12/24/16.
 */
public class SingleView implements View {
    public Image image;

    public SingleView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, Model model) {
        g.drawImage(image, (int)model.getX(), (int)model.getY(), model.getWidth(), model.getHeight(), null);
    }


}
