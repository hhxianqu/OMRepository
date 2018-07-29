package cn.edu.nju.omrepository.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class WindowUtil {

    public void changeScene (String fxml, ActionEvent event) {
        try {
            Scene scene = ((Node)event.getSource()).getScene();
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
