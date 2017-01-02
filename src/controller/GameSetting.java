package controller;

import com.sun.javafx.sg.prism.NGShape;
import model.Model;

/**
 * Created by apple on 12/24/16.
 */
public class GameSetting {

    public static final int HEALTH_BAR_WIDTH = 100;
    public static final int HEALTH_BAR_HEIGHT = 20;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static int sleepTime = 17;
    public static int playerStartX = 300;
    public static int playerStartY = 300;
    public static int playerStartHP = 10;
    public static int playerStartScore = 0;
    public static int playerStartLifeTime = 100;


    public static final GameSetting instance = new GameSetting();

    private GameSetting() {

    }


    public boolean isInScreen(Model model) {
        return model.getY() < HEIGHT;
    }


}
