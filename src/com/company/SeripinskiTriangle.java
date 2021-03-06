package com.company;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeripinskiTriangle extends JPanel
{
    private int levels;
    public SeripinskiTriangle(int lev) {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Call JPanel&#39;s paintComponent method to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int [] xcoord = {xCenter - 128, xCenter, xCenter + 128};
        int [] ycoord = {yCenter, yCenter - 128, yCenter};
        g.setColor(Color.RED);
        drawAndSplit(g, xcoord, ycoord, 1);
    }
    public int [] midpoints0(int [] x)
    {
        int [] m = new int [3];
        m[0] = (x[0]);
        m[1] = (x[1] + x[0])/2;
        m[2] = (x[2] + x[0])/2;
        return m;
    }
    public int [] midpoints1(int [] x)
    {
        int [] m = new int [3];
        m[0] = (x[0] + x[1])/2;
        m[1] = (x[1]);
        m[2] = (x[2] + x[1])/2;
        return m;
    }
    public int [] midpoints2(int [] x)
    {
        int [] m = new int [3];
        m[0] = (x[0] + x[2])/2;
        m[1] = (x[1] + x[2])/2;
        m[2] = (x[2]);
        return m;
    }
    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {

        if(times==levels) {
            g.fillPolygon(x, y, 3);
        }
        else {
            drawAndSplit(g, midpoints0(x), midpoints0(y), times + 1);
            drawAndSplit(g, midpoints1(x), midpoints1(y), times + 1);
            drawAndSplit(g, midpoints2(x), midpoints2(y), times + 1);
        }
/****** OOPS! I lost the code ******/
    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SeripinskiTriangle panel = new SeripinskiTriangle(5);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}
