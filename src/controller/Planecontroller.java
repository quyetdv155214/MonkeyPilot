package controller;

import controller.item.*;
import controller.managers.ControllerManager;
import controller.managers.TrapManager;
import controller.trap.TrapController;
import model.Model;
import util.Utils;
import view.Animation;
import view.View;
import controller.managers.BodyManager;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Dell on 17/12/2016.
 */

public class Planecontroller extends Controller implements Body {
    private static final int width = 70;
    private static final int height = 30;
    private int score = 0;
    private double speed = 2;
    private int numOfShield = 0;
    private int turn = 0;
    private int reverseTime = 10;
    GameVector backup;



    private int numOfRocket = 0;
    TrapManager trapManager = new TrapManager();
    GameVector moveVector;
    public static final Planecontroller instance = creat(300, 300);

    private boolean move=true;

    private Planecontroller(Model model, View view) {
        super(model, view);
        moveVector = new GameVector(speed, 0);
//        model.setHp(3);
        BodyManager.instance.register(this);
        model.setX(GameSetting.playerStartX);
        model.setY(GameSetting.playerStartY);
        model.setHp(GameSetting.playerStartHP);
        model.setLiveTime(GameSetting.playerStartLifeTime);
        setScore(GameSetting.playerStartScore);
    }


    public void reset() {
        model.setAlive(true);
        BodyManager.instance.register(this);
        model.setX(GameSetting.playerStartX);
        model.setY(GameSetting.playerStartY);
        model.setHp(GameSetting.playerStartHP);
        model.setLiveTime(GameSetting.playerStartLifeTime);
        setScore(0);
        BodyManager.instance.removeAll();
        for (int i = 0; i < ControllerManager.controllers.size(); i++) {
            ControllerManager.controllers.get(i).getModel().setAlive(false);
        }
        StarController.instance.model.setX(400);
        StarController.instance.model.setX(500);

        BodyManager.instance.register(this);
        BodyManager.instance.register(StarController.instance);
        setMoveVector(new GameVector(speed, 0));
    }


    private static Planecontroller creat(int x, int y) {

        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/character/heli1.png"));
        images.add(Utils.loadImage("resources/character/heli2.png"));
        ;
        Planecontroller planecontroller = new Planecontroller(new Model(x, y, width, height),
                new Animation(images));
        //
        planecontroller.getModel().setMAX_TIME_LIVE(100);
        planecontroller.getModel().setLiveTime(100);
        return planecontroller;
    }


    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getScore() {
        return score;
    }

    public static int deg = 88;
    int timeStun =0;

    public void run() {
        if(move){
            this.getModel().check();

            if (this.getModel().isAlive()) {
                model.decGas();
                if (turn == 1) {
                    deg += 2;
                    double raDeg = Math.toRadians(deg);
                    moveVector.dx = speed * Math.sin(raDeg);
                    moveVector.dy = speed * Math.cos(raDeg);
                    if (deg == 360) {
                        deg = -1;
                    }

                    if (this.model.checkout()) {

                        moveVector.reverse();

                    }
                    this.model.move(moveVector);
                } else {
                    if (this.model.checkout()) {
                        moveVector.reverse();
                    }

                    this.model.move(moveVector);
                }
            }

        }
        else {
            timeStun ++;
            if (timeStun == 100)
            {
                move =true;
                timeStun =0;

            }
        }

    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumOfShield() {
        return numOfShield;
    }

    public GameVector getMoveVector() {
        return moveVector;
    }

    public void setMoveVector(GameVector moveVector) {
        this.moveVector = moveVector;
    }

    public int getNumOfRocket() {
        return numOfRocket;
    }

    public void setNumOfShield(int numOfShield) {
        this.numOfShield = numOfShield;
    }

    public void setNumOfRocket(int numOfRocket) {
        this.numOfRocket = numOfRocket;
    }

    public void icsScore(){
        score++;
        Utils.playSound("resources/sound/play/Pickup_Coin13.wav", false);
        trapManager.create();


    }
    @Override
    public void onContact(Body other) {
        if (other instanceof StarController) {
            icsScore();
        }
        if (other instanceof Meteo) {
            model.decHp(1);
        }
        if (other instanceof TrapController) {
            model.decHp(1);

        }
        if (other instanceof Gas) {
            this.getModel().icsGas(15);

        }
        if (other instanceof ShieldItem) {

            Shiled.instance.getModel().setAlive(true);
            Shiled.instance.getModel().setLiveTime(5);


        }
        if (other instanceof BulletItem) {
//            this.getModel().icsGas(15);

            if (!(numOfRocket >= 5))
                numOfRocket++;
        }
        if (other instanceof HelpPlaneItem){

            Helper.instance.getModel().setAlive(true);
            Helper.instance.getModel().setLiveTime(10);
            BodyManager.instance.register(Helper.instance);


        }


    }
}
