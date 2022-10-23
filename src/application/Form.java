package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Form {
    private static final int LEN = Main.LEN;
    private static final int SPACE = Main.SPACE;
    private static final int START_X = Main.START_X;
    private static final int START_Y = Main.START_Y;

    private static AnchorPane root = Main.root;

    private Rectangle joint;
    private Form prev;
    private int x, y;

    public Form(int x, int y) {
        this.x = x;
        this.y = y;
        joint = new Rectangle(posX(), posY(), LEN, LEN);
        root.getChildren().add(joint);
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
        joint.setX(posX());
        joint.setY(posY());
    }

    public void setPrev(Form p) {
        prev = p;
    }

    private int posX() {
        return START_X + x * SPACE;
    }

    private int posY() {
        return START_Y + y * SPACE;
    }

    public Form getPrev() {
        return prev;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
