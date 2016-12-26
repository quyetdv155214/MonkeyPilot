package controller;

import model.Model;
import view.Animation;
import view.View;

import java.awt.*;

/**
 * Created by quyet on 12/26/2016.
 */
public class TargetController extends Controller {
    public TargetController(Model model, View view) {
        super(model, view);
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
