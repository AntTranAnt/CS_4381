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

    // Calculate coordinate for each corner of square
    public void mousePressed(MouseEvent e) {
        A = new SquarePoint(e.getX(), e.getY(), Color.BLUE);
        int dx = i((e.getX() + e.getX() + sideLength) / 2);
        int dy = i((e.getY() + e.getY() + sideLength) / 2);
        B = new SquarePoint(dx, dy, Color.RED);
        dy = i((dy + dy + sideLength) / 2);
        C = new SquarePoint(e.getX(), dy, Color.GREEN);
        dx = i((e.getX() + e.getX() - sideLength) / 2);
        dy = i((e.getY() + e.getY() + sideLength) / 2);
        D = new SquarePoint(dx, dy, Color.PINK);
        repaint();
    }

    // Draws square on frame
    public void paint(Graphics g) {
        g.drawLine(A.x, A.y, B.x, B.y);
        g.drawLine(B.x, B.y, C.x, C.y);
        g.drawLine(C.x, C.y, D.x, D.y);
        g.drawLine(D.x, D.y, A.x, A.y);

        g.setColor(A.color);
        g.fillOval(A.x - 2, A.y - 2, 4, 4);
        g.drawString("A", A.x - 10, A.y - 10);

        g.setColor(B.color);
        g.fillOval(B.x - 2, B.y - 2, 4, 4);
        g.drawString("D", B.x - 10, B.y - 10);

        g.setColor(C.color);
        g.fillOval(C.x - 2, C.y - 2, 4, 4);
        g.drawString("C", C.x - 10, C.y - 10);

        g.setColor(D.color);
        g.fillOval(D.x - 2, D.y - 2, 4, 4);
        g.drawString("B", D.x - 10, D.y - 10);
    }

    // returns int from float
    int i(float x) {
        return Math.round(x);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}

    public static void main(String[] args) {
        new square();
    }
}