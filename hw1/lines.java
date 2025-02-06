package hw1;
import java.awt.*;
import java.awt.event.*;

public class lines extends Frame {
    int W = 400;
    int H = 400;
    int iter = 7;

    public lines() {
        setSize(W, H);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        float sideLength = width*0.8f;
        int x = (width - i(sideLength)) / 2;
        int y = (height - i(sideLength)) / 2;

        for (int i = 0; i < iter; i++) {
            //regular square
            g.drawLine(x, y, x+i(sideLength), y);
            x += i(sideLength);
            g.drawLine(x, y, x, y+i(sideLength));
            y += i(sideLength);
            g.drawLine(x, y, x-i(sideLength), y);
            x -= i(sideLength);
            g.drawLine(x, y, x, y-i(sideLength));
            y -= i(sideLength);

            //diagonal square
            int dx = i((x + x + sideLength) / 2);
            int dy = i((y + y + sideLength) / 2);
            g.drawLine(dx, y, x+i(sideLength), dy);
            x += i(sideLength);
            g.drawLine(x, dy, dx, y+i(sideLength));
            y += i(sideLength);
            g.drawLine(dx, y, x-i(sideLength), dy);
            x -= i(sideLength);
            g.drawLine(x, dy, dx, y-i(sideLength));
            y -= i(sideLength);

            //Second square parameter change
            x = i((x + (x + x + sideLength) / 2) / 2);
            y = i((y + (y + y + sideLength) / 2) / 2);
            sideLength /= 2;
        }
    }

    int i(float x) {
        return Math.round(x);
    }

    public static void main(String[] args) {
        new lines();
    }
}