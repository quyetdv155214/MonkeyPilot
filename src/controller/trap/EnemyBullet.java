package controller.trap;

import controller.Body;
import controller.Controller;
import controller.GameVector;
import controller.Planecontroller;
import controller.item.Shiled;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

/**
 * Created by Dell on 01/01/2017.
 */
public class EnemyBullet extends Controller implements Body{
    private static int WIDTH= 10;
    private static int HEIGHT = 10;
    private GameVector moveVector;
    private int i;

    public EnemyBullet(Model model, View view,GameVector moveVector) {
        super(model, view);
        BodyManager.instance.register(this);
        this.moveVector= moveVector;
    }
    @Override
    public void run() {
        if (i == 10){
            model.move(moveVector);
            i=0;
        }
        i++;

    }

    public static EnemyBullet create(int x, int y, GameVector moveVector) {
        return new EnemyBullet(
                new Model(x, y, WIDTH, HEIGHT),
                new SingleView(Utils.loadImage("resources/enemy/bullet-round.png")),
               moveVector
        );
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Shiled)
        {
            this.getModel().destroy();
//            System.out.println(this.getModel().isAlive());
        }
        if (other instanceof Planecontroller) {
            this.model.destroy();
            Planecontroller.instance.getModel().decHp(1);
        }

    }
}
