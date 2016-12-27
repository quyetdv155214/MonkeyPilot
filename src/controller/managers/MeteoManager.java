package controller.managers;

import controller.Meteo;

import java.awt.*;

/**
 * Created by Dell on 27/12/2016.
 */
public class MeteoManager extends ControllerManager {
    private int timecount=0;
    public void draw(Graphics g){
        super.draw(g);
    }
    public void run(){
        timecount++;
        super.run();
        if (timecount%3 ==0) spawn();
    }
    public void spawn(){
        controllers.add(Meteo.creat());
    }
}
