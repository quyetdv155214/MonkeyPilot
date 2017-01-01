package controller;

import model.Model;
import util.Utils;
import view.View;

import java.awt.*;

/**
 * Created by Dell on 17/12/2016.
 */
public class Controller implements BaseController{
    protected Model model;
    protected View view;
    public static boolean sound = true;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void draw(Graphics g){
        view.draw(g,model);
    }
    public void run(){

    }
    public static void playsound(String path,boolean repeat,boolean sound){
        if (sound)
            Utils.playSound(path,repeat);
    }


    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
