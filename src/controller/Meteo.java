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
    }
    public void run(){
        this.model.move(-2,4);
        BodyManager.instance.register(this);
    }
    public static Meteo creat(){
        Random ran = new Random();
        int y =0;
        int x = ran.nextInt(600) + 100;
        Meteo meteo = new Meteo(
                new Model((int)x,(int)y,125,96),
                new SingleView(Utils.loadImage("resources/PTS da XOng.png"))
        );
        return meteo;
    }
    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller){
            this.model.destroy();
            this.model.setAlive(false);
            BodyManager.instance.remove(this);
        }
    }
}
