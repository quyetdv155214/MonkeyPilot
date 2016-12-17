package view;

import com.sun.javafx.sg.prism.NGShape;
import model.Model;

import java.awt.*;

/**
 * Created by Dell on 17/12/2016.
 */
public class View {
    Image image;

    public View(Image image) {
        this.image = image;
    }
    public void draw(Graphics g, Model model){
        g.drawImage(image,model.getX(),model.getY(),model.getWidth(),model.getHeight(),null);
    }
}
