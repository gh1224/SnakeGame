package application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    private static final int X_NUM = Main.X_NUM;
    private static final int Y_NUM = Main.Y_NUM;
    private static final int INIT_JOINT = Main.INIT_JOINT;
    private static final int LEN = Main.LEN;
    private static final int DELAY = Main.DELAY;
    private static final int SPACE = Main.SPACE;
    private static final int START_X = Main.START_X;
    private static final int START_Y = Main.START_Y;

    private static Scene scene = Main.scene;
    private static AnchorPane root = Main.root;

    public static int[][] board = new int[X_NUM][Y_NUM];
    private Snake snake;
    private Timer timer;
    private TimerTask timerTask;
    private Circle apple;

    public void play() {
        setting();
        init();

        start();
    }

    public void setting() {
        apple = new Circle(LEN / 2, Color.rgb(255, 0, 0));
        root.getChildren().add(apple);

        timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (!snake.go())
                            timer.cancel();
                    }
                });
            }
        };
    }

    public void init() {
        snake = new Snake();
        for (int i = 0; i < X_NUM; i++)
            for (int j = 0; j < Y_NUM; j++)
                board[i][j] = 0;

        int firstX = X_NUM / 2;
        int firstY = Y_NUM / 2;
        for (int i = INIT_JOINT - 1; i >= 0; i--) {
            snake.addItem(new Form(firstX, firstY + i));
            board[firstX][firstY + i] = 1;
        }

        setApple();
        timer = new Timer();
    }

    public void start() {
        timer.schedule(timerTask, DELAY, DELAY);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                if (key == KeyCode.UP)
                    snake.goUp();
                if (key == KeyCode.DOWN)
                    snake.goDown();
                if (key == KeyCode.RIGHT)
                    snake.goRight();
                if (key == KeyCode.LEFT)
                    snake.goLeft();
            }
        });
    }

    public void setApple() {
        int randNum;
        int x, y;
        while (true) {
            randNum = (int)(Math.random() * X_NUM * Y_NUM);
            x = randNum / X_NUM;
            y = randNum % X_NUM;
            if (board[x][y] == 0)
                break;
        }
        board[x][y] = 2;
        apple.setCenterX(START_X + x * SPACE + LEN / 2);
        apple.setCenterY(START_Y + y * SPACE + LEN / 2);
    }
}
