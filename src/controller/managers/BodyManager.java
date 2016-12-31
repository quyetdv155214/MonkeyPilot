package controller.managers;

import controller.BaseController;
import controller.Body;
import controller.Planecontroller;
import model.Model;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Duc Duong on 12/17/2016.
 */
public class BodyManager implements BaseController{
    private Vector<Body> bodies;

    public static final BodyManager instance = new BodyManager();

    private BodyManager(){
        bodies = new Vector<>();
    }

    public void register(Body body){
        this.bodies.add(body);
    }
    public void remove(Body body){
        this.bodies.remove(body);
        System.out.println(" remove ");
    }
    public void removeAll(){
        this.bodies.removeAllElements();
    }


    public void run(){
//        System.out.println(bodies.size());

        Iterator<Body> iterator = this.bodies.iterator();
        while (iterator.hasNext()) {
            Body body = iterator.next();
            if (body.getModel().checkDead()) {
                if (!(body instanceof Planecontroller))
                {
                    iterator.remove();
                }
            }
        }

        for (int i = 0; i < bodies.size() -1; i++){
            for (int j = i+1; j < bodies.size(); j++){

                Body bodyi =  bodies.get(i);
                Body bodyj =  bodies.get(j);

                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if(modeli.interects(modelj)){
//                    System.out.println("Contacted");
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {

    }
}
