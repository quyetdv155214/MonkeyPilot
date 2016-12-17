package controller;

import model.Model;
import util.Utils;
import view.View;

/**
 * Created by Dell on 17/12/2016.*/
public class Planecontroller extends Controller {
    private static final int width =70;
    private static final int height =50;

    public Planecontroller(Model model, View view) {
        super(model, view);
    }
    public static Planecontroller creat(int x,int y){
        return new Planecontroller(new Model(x,y,width,height),new View(Utils.loadimage("resources/plane2.png")));
    }
    public static int deg =0;
    public void run(){
        double x;
        double y;
        
        deg++;
        
        double raDeg = Math.toRadians(deg);
        if (deg >270 &&deg <360){


        }

        this.model.move(x,y);
    }

}
