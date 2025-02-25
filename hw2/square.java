import java.awt.*;
import java.awt.event.*;

public class square extends Frame implements MouseListener {
    // Class to represent point on square
    class SquarePoint {
        int x, y;
        Color color;

        SquarePoint(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    private int W = 400;
    private int H = 400;
    private SquarePoint A, B, C, D;
    private float sideLength = W*0.4f;

    public square() {
        setSize(W, H);
        setVisible(true);

        addMouseListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void mousePressed(MouseEvent e) {
        A = new SquarePoint(e.getX(), e.getY(), Color.BLUE);
        int dx = i((e.getX() + e.getX() + sideLength) / 2);
        int dy = i((e.getY() + e.getY() + sideLength) / 2);
        B = new SquarePoint(dx, dy, Color.RED);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawLine(A.x, A.y, B.x, B.y);
    }

    int i(float x) {
        return Math.round(x);
    }

    public static void main(String[] args) {
        new square();
    }
}