package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by Dell on 17/12/2016.
 */
public class Utils {
    public static Image loadimage(String path){
        Image image;
        try {
            image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
