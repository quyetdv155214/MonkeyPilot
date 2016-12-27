package controller;

import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;


/**
 * Created by quyet on 12/26/2016.
 */
public class TargetController extends Controller {
    public TargetController(Model model, View view) {
        super(model, view);
    }
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public static TargetController create (int x , int y ){
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/target1.png"));
        images.add(Utils.loadImage("resources/target2.png"));
        images.add(Utils.loadImage("resources/target3.png"));
        images.add(Utils.loadImage("resources/target4.png"));
        images.add(Utils.loadImage("resources/target5.png"));
        images.add(Utils.loadImage("resources/target6.png"));
        //
        TargetController t = new TargetController(
                new Model(x, y, WIDTH, HEIGHT),
                new Animation(images)
        );

        return t;

    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Animation animation = (Animation)this.view;
        if (animation.isAnimationReachEnd()) {
            model.setAlive(false);
        }
    }
}
