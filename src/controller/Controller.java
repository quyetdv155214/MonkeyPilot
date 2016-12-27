package controller;

import model.Model;
import view.View;

import java.awt.*;

/**
 * Created by Dell on 17/12/2016.
 */
public class Controller implements BaseController{
    protected Model model;
    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    public void draw(Graphics g){
        view.draw(g,model);
    }
    public void run(){

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
