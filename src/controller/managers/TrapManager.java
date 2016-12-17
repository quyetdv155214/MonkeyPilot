package controller.managers;

import controller.TrapController;

import java.util.Vector;

/**
 * Created by q on 12/17/2016.
 */
public class TrapManager  {
    public Vector<TrapController> trapControllers ;

    public TrapManager() {
        this.trapControllers = new Vector<>();
    }

}
