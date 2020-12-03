package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button thirdButton;

    @FXML
    private Button firstButton;

    @FXML
    private Button secondButton;

    @FXML
    private Button lastButton;

    @FXML
    private TextField inpz;

    @FXML
    private Button fourthButton;

    @FXML
    void initialize() {
        firstButton.setOnMouseClicked((event) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 824, 400);
                Stage stage = new Stage();
                stage.setTitle("Общий список книг");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });
        thirdButton.setOnMouseClicked((event) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("view3.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 400);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });

        secondButton.setOnMouseClicked((event) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("view2.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 400);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });
        fourthButton.setOnMouseClicked((event) -> {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("view4.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 400);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });


        lastButton.setOnMouseClicked((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("lastview.fxml"));
                fxmlLoader.setController(new lastController(inpz.getText()));
                Scene scene = new Scene(fxmlLoader.load(), 900, 400);
                Stage stage = new Stage();
                stage.setTitle("Книги старше "+inpz.getText()+" лет");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        });
    }
}

