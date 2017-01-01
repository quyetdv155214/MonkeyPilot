import util.IO;

import java.io.IOException;

/**
 * Created by Dell on 17/12/2016.
 */
public class Program {
    public static void main(String[] args){
        Pilot pilot = null;
        try {
            pilot = new Pilot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        IO.loadGame();
        Thread thread = new Thread(pilot);
        thread.start();
    }
}
