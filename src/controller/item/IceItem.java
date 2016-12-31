package controller.item;

import controller.Body;
import controller.Controller;
import controller.GameVector;
import controller.Planecontroller;
import controller.managers.BodyManager;
import controller.managers.ControllerManager;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

/**
 * Created by Dell on 01/01/2017.
 */
public class IceItem extends Controller implements Body {
    private static final int WIDTH =40 ;
    private static final int HEIGHT =40 ;
    public IceItem(Model model, View view) {
        super(model, view);

        BodyManager.instance.register(this);
    }
    int time= 0;
    public void run(){
        super.run();
        time++ ;
        if (time== 3)
        {
            model.move(0,1);
            time=0;
        }
    }
    public static IceItem creat(int x,int y){
        return new IceItem(
                new Model(x,y,WIDTH,HEIGHT),
                new SingleView(Utils.loadImage("resources/ice.png"))
        );
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller)
        {
            ControllerManager.instance.slow =5;
            System.out.println("aaaaaaaaaa");
            this.getModel().setAlive(false);
        }
    }
}
