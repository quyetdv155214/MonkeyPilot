package util;

import javafx.scene.control.Alert;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by apple on 12/7/16.
 */
public class Utils {
    public static Point point = new Point();

    public static BufferedImage loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return image;
//            ImageIcon i =new ImageIcon(this.getClass().getResource("/images/xxx.jpg"))
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void playSound(String audioUrl, boolean repeat) {

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

//            clip.stop();
//            long microsecondPosition = clip.getMicrosecondPosition();
//            clip.setMicrosecondPosition(microsecondPosition);
//            clip.start();
//            clip.loop(100);

            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void getLocation(int x, int y) {
        point = new Point(x, y);
    }

    public static Clip clip;
    public static void playSound2(String audioUrl, boolean repeat) {

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

//            clip.stop();
//            long microsecondPosition = clip.getMicrosecondPosition();
//            clip.setMicrosecondPosition(microsecondPosition);
//            clip.start();
//            clip.loop(100);

            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void playSound2(String audioUrl, boolean repeat,boolean stop) {
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            clip.close();
//            clip.loop(100);

            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void playSound(String audioUrl, boolean repeat , boolean tt) {

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            if (tt){
                clip.stop();
                clip.close();
            }else{

                clip.open(audioIn);
                clip.start();
            }
//            clip.loop(100);

            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playSound2(String audioUrl, boolean repeat, Clip b, AudioInputStream c) {

        File soundFile = new File(audioUrl);
        try {
            c = AudioSystem.getAudioInputStream(soundFile);
            b = AudioSystem.getClip();
            b.open(c);
            b.start();

            if (repeat) {
                b.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                b.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static Vector<BufferedImage> loadSheet(String URL, int width, int height, int border, int col) {
        BufferedImage image = Utils.loadImage(URL);
        Vector<BufferedImage> bufferedImages = new Vector<>();
        for (int index = 0; index < col; index++) {
            int x = index * width + border * (index + 1);
            int y = border;
            BufferedImage subImage = image.getSubimage(x, y, width, height);
            bufferedImages.add(subImage);
        }
        return bufferedImages;
    }

    public static Vector<BufferedImage> loadSheet(String URL, int width, int height, int border, int col, int row) {

        BufferedImage image = Utils.loadImage(URL);
        Vector<BufferedImage> bufferedImages = new Vector<>();
        for (int i = 0; i < row; i++) {
            int y = border + height * i;
            for (int index = 0; index < col; index++) {
                int x = index * width + border * (index + 1);

                BufferedImage subImage = image.getSubimage(x, y, width, height);
                bufferedImages.add(subImage);
            }
        }
        return bufferedImages;
    }

    public void rotate(int deg) {

    }


}
