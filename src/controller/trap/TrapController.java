package controller.trap;

import controller.Body;
import controller.Controller;
import controller.GameSetting;
import controller.Planecontroller;
import controller.item.FireCircle;
import controller.item.Helper;
import controller.managers.BodyManager;
import controller.managers.TrapManager;
import model.Model;
import util.Utils;
import view.Animation;
import view.SingleView;
import view.View;

import java.awt.*;
import java.util.Random;

/**
 * Created by q on 12/17/2016.
 */
public class TrapController extends Controller implements Body {
    private static final int width = 50;
    private static final int height = 30;

    public TrapController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    static int count = 0;
    public static TrapController create() {
        Random ran = new Random();
        int x = ran.nextInt(GameSetting.instance.getWidth() -200) + 100;
        int y = ran.nextInt(GameSetting.instance.getHeight() -200) + 100;
        return create(x, y);

    }
    public static TrapController create(double x,double y){
        TrapController trapController = new TrapController(new Model(x, y, width, height),
                new SingleView(Utils.loadImage("resources/bomb.png")));
        trapController.getModel().setHp(1);
        return trapController;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void run() {

    }

    @Override
    public void onContact(Body other) {
        if (other instanceof FireCircle || other instanceof Helper) {
            this.getModel().destroy();
        }
        if (other instanceof FireCircle)
        {
            this.getModel().destroy();
        }
    }
}
