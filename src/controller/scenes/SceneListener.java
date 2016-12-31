package controller.scenes;

/**
 * Created by quyet on 12/28/2016.
 */
public interface SceneListener {
     void replaceScene(GameScene newScene, boolean addToBackStack);
     void back();
}
