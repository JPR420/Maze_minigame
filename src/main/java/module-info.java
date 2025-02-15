module edu.farmingdale.the_maze {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.the_maze to javafx.fxml;
    exports edu.farmingdale.the_maze;
}