package view;

import com.sun.javafx.sg.prism.NGShape;
import model.Model;

import java.awt.*;

/**
 * Created by Dell on 17/12/2016.
 */
public interface View {


    void draw(Graphics g, Model model);
}
