package controller;

import model.Model;
import util.Utils;
import view.View;

/**
 * Created by Dell on 17/12/2016.*/
public class Planecontroller extends Controller {
    private static final int width =70;
    private static final int height =50;
    double x;
    double y;
    private int n=0;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }


    public Planecontroller(Model model, View view) {
        super(model, view);
    }
    public static Planecontroller creat(int x,int y){
        return new Planecontroller(new Model(x,y,width,height),new View(Utils.loadimage("resources/plane2.png")));
    }
    public static int deg =-1;
    public void run(){

        deg++;

        double raDeg = Math.toRadians(deg);
           if(n==1) {
               x = 2 * Math.sin(raDeg);
               y = 2 * Math.cos(raDeg);
               if (deg == 360) {
                   deg = -1;
               }
               this.model.move(y,x);
           }
        else this.model.move(y,x);
    }

}
