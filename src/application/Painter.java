package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Painter {
    private static final int WIDTH = Main.WIDTH;
    private static final int HEIGHT = Main.HEIGHT;
    private static final int START_X = Main.START_X;
    private static final int START_Y = Main.START_Y;

    private static AnchorPane root = Main.root;

    private static final int THICK = 3;

    private Line[] bounds = new Line[4];

    public void draw() {
        bounds[0] = new Line(START_X, START_Y, START_X, START_Y + HEIGHT);
        bounds[1] = new Line(START_X + WIDTH, START_Y, START_X + WIDTH, START_Y + HEIGHT);
        bounds[2] = new Line(START_X, START_Y, START_X + WIDTH, START_Y);
        bounds[3] = new Line(START_X, START_Y + HEIGHT, START_X + WIDTH, START_Y + HEIGHT);

        for (int i = 0; i < 4; i++) {
            bounds[i].setStrokeWidth(THICK);
            bounds[i].setStroke(Color.rgb(0, 255, 0));
            root.getChildren().addAll(bounds[i]);
        }
    }
}
