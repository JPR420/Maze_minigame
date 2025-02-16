package edu.farmingdale.the_maze;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class HelloController {

    @FXML
    ImageView maze;
    @FXML
    ImageView robot;
    @FXML
    AnchorPane pane;

    Image robotPlayer = new Image(String.valueOf(getClass().getResource("/robot.png")));
    Image mazePicture = new Image(String.valueOf(getClass().getResource("/maze.png")));

    @FXML
    public void initialize() {
        maze.setImage(mazePicture);
        robot.setImage(robotPlayer);


        robot.setFocusTraversable(true);
        robot.requestFocus();
    }

    @FXML
    private void onHelloButtonClick(KeyEvent event) {
        double currentX = robot.getLayoutX();
        double currentY = robot.getLayoutY();


        switch (event.getCode()) {
            case UP:
                robot.setLayoutY(currentY - 10);
                break;
            case DOWN:
                robot.setLayoutY(currentY + 10);
                break;
            case LEFT:
                robot.setLayoutX(currentX - 10);
                break;
            case RIGHT:
                robot.setLayoutX(currentX + 10);
                break;
            default:
                break;
        }
    }
}
