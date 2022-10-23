package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int X_NUM = 15;
    public static final int Y_NUM = 15;
    public static final int INIT_JOINT = 3;
    public static final int LEN = 30;
    public static final int GAP = 1;
    public static final int DELAY = 200;
    public static final int SPACE = LEN + GAP;
    public static final int WIDTH = SPACE * X_NUM;
    public static final int HEIGHT = SPACE * Y_NUM;
    public static final int START_X = 200;
    public static final int START_Y = 100;
    public static final int WINDOW_X = WIDTH + START_X * 2;
    public static final int WINDOW_Y = HEIGHT + START_Y * 2;

    public static AnchorPane root = new AnchorPane();
    public static Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
    public static Controller control = new Controller();
    public static Painter painter = new Painter();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        painter.draw();
        control.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
