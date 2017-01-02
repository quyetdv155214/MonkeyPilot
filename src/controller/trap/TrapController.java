package controller.trap;

import controller.Body;
import controller.Controller;
import controller.GameSetting;
import controller.Planecontroller;
import controller.item.Shiled;
import controller.item.Helper;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

/**
 * Created by q on 12/17/2016.
 */
public class TrapController extends Controller implements Body {
    private static final int width = 60;
    private static final int height = 60;

    public TrapController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    static int count = 0;

    public static TrapController create() {
        Random ran = new Random();
        int x = ran.nextInt(GameSetting.WIDTH - 200) + 100;
        int y = ran.nextInt(GameSetting.HEIGHT- 200) + 100;
        return create(x, y);

    }

    public static TrapController create(double x, double y) {
        Vector<BufferedImage> images = Utils.loadSheet("resources/enemy/bomb_game_sprite.png", 128, 128, 0, 3);
        TrapController trapController = new TrapController(new Model(x, y, width, height),
                new Animation(images));
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

        if ( other instanceof Helper|| other instanceof Planecontroller || other instanceof Shiled || other instanceof EnemyBullet) {
            Controller.playsound("resources/sound/play/Vacham.wav", false, Controller.sound);
            this.getModel().destroy();
        }

    }
}
