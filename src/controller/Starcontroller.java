package controller;

import controller.managers.BodyManager;
import model.Model;
import view.View;

/**
 * Created by Dell on 17/12/2016.
 */
public class Starcontroller extends Controller implements Body{

    public Starcontroller(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof Planecontroller) {
            System.out.println("Da va cham @@@@@@@@@");
        }
    }
}
