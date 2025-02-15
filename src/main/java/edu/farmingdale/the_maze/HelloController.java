package edu.farmingdale.the_maze;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML
    ImageView maze;
    @FXML
    ImageView robot;

    Image robotPlayer = new Image(String.valueOf(getClass().getResource("/robot.png")));
    Image mazePicture = new Image(String.valueOf(getClass().getResource("/maze.png")));

    @FXML
    public void initialize() {
        maze.setImage(mazePicture);
        robot.setImage(robotPlayer);
    }

    @FXML
    protected void onHelloButtonClick(javafx.scene.input.MouseEvent event) {
        robot.setTranslateX(robot.getTranslateX() + 10);
    }
}