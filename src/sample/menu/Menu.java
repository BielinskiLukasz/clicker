package sample.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    @FXML
    private Button startButton;

    @FXML
    public void startGame(ActionEvent actionEvent) {
//        Parent root =FXMLLoader.load(getClass().getResource("menu/menu.fxml"));
        try {
            Parent root = FXMLLoader.load(getClass().getResource("game/view/world.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root, 820, 700);

            stage.setResizable(false);

            stage.setTitle("GAME");
            stage.setScene(scene);
            stage.show();

            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
