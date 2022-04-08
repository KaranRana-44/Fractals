package com.company;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxSpiral extends JPanel
{
    private int levels;
    public BoxSpiral(int lev) {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Call JPanel&#39;s paintComponent method to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int [] xcoord = {xCenter - 128, xCenter-128, xCenter + 128, xCenter + 128};
        int [] ycoord = {yCenter-128, yCenter + 128, yCenter + 128, yCenter - 128};
        g.setColor(Color.RED);
        drawAndSplit(g, xcoord, ycoord, 1);
    }
    public int [] midpoints(int [] x)
    {
        int [] m = new int [4];
        m[0] = (x[0] + x[3])/3;
        m[1] = x[1];
        m[2] = 2*(x[1] + x[2])/3;
        m[3] = x[3];
        return m;
    }
    public int [] midpoints1(int [] x)
    {
        int [] m = new int [4];
        m[0] = (x[0]);
        m[1] = 2*(x[0]+x[1])/3;
        m[2] = x[2];
        m[3] = (x[2]+x[3])/3;
        return m;
    }
    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {
        if(times==levels) {
            g.drawPolygon(x, y, 4);
        }
        else {
            g.drawPolygon(x, y, 4);
            g.setColor(Color.BLUE);
            drawAndSplit(g, midpoints(x),midpoints1(y), times + 1);
        }
/****** OOPS! I lost the code ******/
    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxSpiral panel = new BoxSpiral(6);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}

