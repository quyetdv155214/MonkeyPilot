package controller;

import model.Model;
import view.Animation;
import view.View;

import java.awt.*;

/**
 * Created by Dell on 26/12/2016.
 */
public class ExplosionController extends Controller {
    public ExplosionController(Model model, View view) {
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
