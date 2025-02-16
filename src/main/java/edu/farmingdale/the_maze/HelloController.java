package edu.farmingdale.the_maze;

import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    ImageView maze;
    @FXML
    ImageView robot;
    @FXML
    AnchorPane pane;

    Image robotPlayer = new Image(String.valueOf(getClass().getResource("/robot.png")));
    Image mazePicture = new Image(String.valueOf(getClass().getResource("/maze.png")));

    PixelReader readerX = mazePicture.getPixelReader();
    private final Color WALL_COLOR = readerX.getColor(5, 5);
    private final Color PATH_COLOR = Color.WHITE;

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
                if (isValidMove(currentX, currentY - 10)) {
                    robot.setLayoutY(currentY - 10);
                }
                break;
            case DOWN:
                if (isValidMove(currentX, currentY + 10)) {
                    robot.setLayoutY(currentY + 10);
                }
                break;
            case LEFT:
                if (isValidMove(currentX - 10, currentY)) {
                    robot.setLayoutX(currentX - 10);
                }
                break;
            case RIGHT:
                if (isValidMove(currentX + 10, currentY)) {
                    robot.setLayoutX(currentX + 10);
                }
                break;
            default:
                break;
        }
    }


    private boolean isValidMove(double x, double y) {

        PixelReader reader = mazePicture.getPixelReader();

        if (reader != null) {

            int pixelX = (int) (x + robot.getFitWidth() / 2);
            int pixelY = (int) (y + robot.getFitHeight() / 2);


            if (pixelX >= 0 && pixelY >= 0 && pixelX < maze.getImage().getWidth() && pixelY < maze.getImage().getHeight()) {

                Color color = reader.getColor(pixelX, pixelY);


                return !color.equals(WALL_COLOR);
            }
        }
        return false;
    }
}
