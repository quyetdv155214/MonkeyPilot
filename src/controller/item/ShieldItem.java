package controller.item;

import controller.Body;
import controller.Controller;
import controller.GameVector;
import controller.Planecontroller;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by quyet on 12/27/2016.
 */
public class ShieldItem extends Controller implements Body{
    private static final int WIDTH =40 ;
    private static final int HEIGHT =40 ;
    GameVector gameVector;
    public ShieldItem(Model model, View view) {
        super(model, view);
        this.gameVector = new GameVector(0,1);
        BodyManager.instance.register(this);
    }
    int time= 0;

    @Override
    public void run() {
        super.run();
        time++ ;
        if (time== 3)
        {
            model.move(gameVector);
    time=0;
        }

    }

    public static ShieldItem create(int x, int y) {
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/Captain_America_Shield_edit.png"));
        //
        ShieldItem s = new ShieldItem(
                new Model(x, y, WIDTH,HEIGHT),
                new Animation(images));
        return s;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller)
        {
            this.getModel().setAlive(false);
        }
    }
}
