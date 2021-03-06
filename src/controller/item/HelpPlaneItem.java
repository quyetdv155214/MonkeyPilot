package controller.item;

import controller.Body;
import controller.Controller;
import controller.Planecontroller;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

/**
 * Created by quyet on 1/1/2017.
 */
public class HelpPlaneItem extends Controller implements Body{
    private static final int WIDTH =40 ;
    private static final int HEIGHT =40 ;
    int time;
    public HelpPlaneItem(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    @Override
    public void run() {

        time++ ;
        if (time== 3)
        {
            model.move(0,1);
            time=0;
        }
    }

    public static HelpPlaneItem creat(int x, int y){
        return new HelpPlaneItem(
                new Model(x,y,WIDTH,HEIGHT),
                new SingleView(Utils.loadImage("resources/item/power-up.png"))
        );
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller || other instanceof Helper) {
            this.getModel().setAlive(false);
            Controller.playsound("resources/sound/play/Anqua.wav",false,Controller.sound);
        }
    }
}
