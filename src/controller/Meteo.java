package controller;

import controller.managers.BodyManager;
import model.Model;
import util.Utils;
import view.SingleView;
import view.View;

import javax.rmi.CORBA.Util;
import java.awt.image.BufferedImage;
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
        int x = ran.nextInt(GameSetting.instance.getWidth() -200) + 100;
        Meteo meteo = new Meteo(
                new Model(x,y,62,48),
                new SingleView(Utils.loadImage("resources/PTS da XOng.png"))
        );
        return meteo;
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller){

//            BodyManager.instance.remove(this);
            this.model.destroy();

        }
    }
}
