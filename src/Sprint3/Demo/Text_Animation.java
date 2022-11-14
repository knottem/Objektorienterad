package Sprint3.Demo;

import java.awt.Color;
import java.awt.Font;

import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Text_Animation extends JPanel{

    int x;
    int x2 = x;
    int x3;
    int bannerSize = 20;
    int y = bannerSize;
    int y2 = y;
    int y3;
    static int tileSize = 100;
    public static int totalSize = tileSize*4;
    int timer;

    public void paint(Graphics gp) {

        super.paint(gp);
        Graphics2D g2d= (Graphics2D) gp;
        g2d.setColor(Color.red);
        g2d.setFont(new Font("BOLD", BOLD, 35));

        drawStringXY("Test", 25,g2d);

        repaint();
    }

    private void drawStringXY(String text, int updateSpeed, Graphics2D g2d){
        int length = g2d.getFontMetrics().stringWidth(text);
        int height = g2d.getFontMetrics().getHeight();

        g2d.drawString(text,x, y);
        timer++;
                if(timer >= updateSpeed) {
                    if (x == x2) {
                        x += 2;
                        x2 += 2;
                        if (x2 + length >= totalSize) {
                            x3 = x;
                            x2 = totalSize + 5000;
                        }
                    }
                    if (y == y2) {
                        y += 2;
                        y2 += 2;
                        if (y2 + height >= totalSize) {
                            y = totalSize - height;
                            y3 = y;
                            y2 = totalSize + 5000;
                        }
                    }
                    if (x == x3) {
                        x -= 2;
                        x3 -= 2;
                        if (x == 0) {
                            x2 = 0;
                        }
                    }
                    if (y == y3) {
                        y -= 2;
                        y3 -= 2;
                        if (y <= bannerSize) {
                            y2 = bannerSize;
                            y = bannerSize;
                        }
                    }
                    timer = 0;
                }
    }

    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setSize(totalSize, totalSize);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.add(new Text_Animation());
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

}