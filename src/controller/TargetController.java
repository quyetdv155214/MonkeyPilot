package controller;

import controller.managers.ControllerManager;
import controller.trap.TrapController;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
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

    public static TargetController create(int x, int y) {
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/enemy/target1.png"));
        images.add(Utils.loadImage("resources/enemy/target2.png"));
        images.add(Utils.loadImage("resources/enemy/target3.png"));
        images.add(Utils.loadImage("resources/enemy/target4.png"));

        TargetController t = new TargetController(
                new Model(x, y, WIDTH, HEIGHT),
                new Animation(images, 20)
        );

        return t;

    }

    public static TargetController create() {
        Random ran = new Random();
        int x = ran.nextInt(GameSetting.WIDTH- 200) + 100;
        int y = ran.nextInt(GameSetting.HEIGHT - 200) + 100;

        return create(x, y);

    }


    int count = 0;

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Animation animation = (Animation) this.view;
        count++;
        if (animation.isAnimationReachEnd() && count == 600) {
            model.setAlive(false);
            TrapController trapController = TrapController.create(model.getX(), model.getY());
            ControllerManager.controllers.add(trapController);
        }
    }
}
