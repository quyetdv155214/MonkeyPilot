package model;

/**
 * Created by q on 12/18/2016.
 */
public class BackGround {
    private int bgX;
    private int bgY;
    private int bgSpeed;


    public BackGround(int bgX, int bgY) {
        this.bgX = bgX;
        this.bgY = bgY;
        this.bgSpeed = -1;
    }
    public void update(){
        bgX +=bgSpeed;
        if (bgX<=-2300){
            bgX=2300;
        }
    }


    public int getBgX() {
        return bgX;
    }

    public void setBgX(int bgX) {
        this.bgX = bgX;
    }

    public int getBgY() {
        return bgY;
    }

    public void setBgY(int bgY) {
        this.bgY = bgY;
    }

    public int getBgSpeed() {
        return bgSpeed;
    }

    public void setBgSpeed(int bgSpeed) {
        this.bgSpeed = bgSpeed;
    }
}
