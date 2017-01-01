package util;

import controller.GameSetting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Dell on 01/01/2017.
 */
public class IO {
    private static final PrintStream main = System.out;

    public void saveGame(){
        try {
            System.setOut(new PrintStream(new File("data/saved_data.txt")));
            System.out.println("3cham");
            System.out.println("techkidsvn");
            System.out.println(112017);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame(){
        //read from file
        try {
            System.setOut(main);
            Scanner sc = new Scanner(new File("data/saved_data.txt"));
            GameSetting.sleepTime = sc.nextInt();
            GameSetting.playerStartX = sc.nextInt();
            GameSetting.playerStartY = sc.nextInt();
            GameSetting.playerStartHP = sc.nextInt();
            GameSetting.playerStartLifeTime = sc.nextInt();
            GameSetting.playerStartScore = sc.nextInt();

//            System.out.println(sc.nextLine());
//            System.out.println(sc.nextLine());
//            System.out.println(sc.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
