package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Model;

/**
 * Created by Duc Duong on 12/17/2016.
 */
public interface   Body {
    Model getModel();
    void onContact(Body other);
}
