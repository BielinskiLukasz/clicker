import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Dany utwór powstał w wyniku realizowania procesu edukacyjnego w PJATK.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu/menu.fxml"));

        Scene scene = new Scene(root, 450, 275);

        primaryStage.setResizable(false);
        primaryStage.setTitle("GAME MENU");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
