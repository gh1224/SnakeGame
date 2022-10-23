package application;

public class Snake {
    private static final int X_NUM = Main.X_NUM;
    private static final int Y_NUM = Main.Y_NUM;

    private static Controller control = Main.control;

    private Form head;
    private Form tail;
    private int direct;

    public Snake() {
        head = null;
        direct = 0;
    }

    public void goUp() {
        direct = 0;
    }

    public void goRight() {
        direct = 1;
    }

    public void goDown() {
        direct = 2;
    }

    public void goLeft() {
        direct = 3;
    }

    public boolean go() {
        control.board[tail.getX()][tail.getY()] = 0;

        int headX = head.getX();
        int headY = head.getY();
        switch(direct) {
            case 0:
                if (headY == 0 || control.board[headX][headY - 1] == 1)
                    return false;
                tail.setXY(headX, headY - 1);
                break;
            case 1:
                if (headX == X_NUM - 1 || control.board[headX + 1][headY] == 1)
                    return false;
                tail.setXY(headX + 1, headY);
                break;
            case 2:
                if (headY == Y_NUM - 1 || control.board[headX][headY + 1] == 1)
                    return false;
                tail.setXY(headX, headY + 1);
                break;
            case 3:
                if (headX == 0 || control.board[headX - 1][headY] == 1)
                    return false;
                tail.setXY(headX - 1, headY);
                break;
        }
        if (control.board[tail.getX()][tail.getY()] == 2)
            eat();
        control.board[tail.getX()][tail.getY()] = 1;

        tail = tail.getPrev();
        head = head.getPrev();
        return true;
    }

    public void addItem(Form f) {
        if (head == null)
            tail = f;
        else {
            head.setPrev(f);
            f.setPrev(tail);
        }
        head = f;
    }

    public void eat() {
        control.setApple();

        Form f = new Form(tail.getX(), tail.getY());
        f.setPrev(tail);
        tail = f;
        head.setPrev(tail);
    }
}
