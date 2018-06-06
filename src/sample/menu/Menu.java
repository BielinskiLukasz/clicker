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
    public void startGame(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.
                load(getClass().
                        getResource("game/main.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root, 450, 275);

        stage.setResizable(false);

        stage.setTitle("GAME");
        stage.setScene(scene);
        stage.show();

        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
}
