package menu;

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
        try {
            Parent root = setRoot("game/view/world.fxml");

            Stage stage = new Stage();
            Scene scene = new Scene(root, 820, 700);

            initStage(stage, scene);

            hideMenuAfterGameStart(actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parent setRoot(String url) throws IOException {
        return FXMLLoader.load(getClass().getResource(url));
    }

    private void initStage(Stage stage, Scene scene) {
        stage.setResizable(false);
        stage.setTitle("GAME");
        stage.setScene(scene);
        stage.show();
    }

    private void hideMenuAfterGameStart(ActionEvent actionEvent) {
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
}
