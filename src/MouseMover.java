import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class MouseMover {

    Robot robot = new Robot();
    int x, y;

    public MouseMover() throws AWTException {
    }

    void moveMouse() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x = screenSize.width/2 - 100;
        y = screenSize.height/2 - 100;

        robot.mouseMove(x, y);
        movement("+", "+",100, 2);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(1000);
        movement("+", "-",200, 2);
        movement("-", "-",100, 2);
        movement("-", "+",200, 2);
        robot.delay(2000);
    }
    private void movement(String xMove, String yMove,int times, int delay){

        for (int i = 0; i < times; i++) {
            if(xMove.equals("+") && yMove.equals("+")) {
                x++;
                y++;
            }else if(xMove.equals("+") && yMove.equals("-")){
                x++;
                y--;
            }else if(xMove.equals("-") && yMove.equals("+")){
                x--;
                y++;
            }else if(xMove.equals("-") && yMove.equals("-")){
                x--;
                y--;
            }
            robot.mouseMove(x,y);
            robot.delay(delay);
        }

    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        MouseMover mouseMover = new MouseMover();
        mouseMover.moveMouse();
    }
}
