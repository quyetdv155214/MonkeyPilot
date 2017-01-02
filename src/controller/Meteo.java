package controller;

import controller.item.Shiled;
import controller.item.Helper;
import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

import java.util.Random;

/**
 * Created by Dell on 27/12/2016.
 */
public class Meteo extends Controller implements Body {
    public Meteo(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);

    }
    public void run(){
        this.model.move(-1,2);
    }

    public static Meteo creat(){
        Random ran = new Random();
        int y =0;
        int x = ran.nextInt(GameSetting.WIDTH -200) + 100;
        Meteo meteo = new Meteo(
                new Model(x,y,62,48),
                new SingleView(Utils.loadImage("resources/enemy/PTS da XOng.png"))
        );
        return meteo;
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Shiled || other instanceof Helper)
        {
            model.destroy();
        }
        if (other instanceof Planecontroller){

//            BodyManager.instance.remove(this);
            this.model.destroy();

        }
    }
}
