package com.company;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxFractal extends JPanel
{
    private int levels;
    public BoxFractal(int lev) {
        levels = lev;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Call JPanel&#39;s paintComponent method to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g.setColor(Color.RED);

        int x = xCenter - 243;
        int y = yCenter - 243;
        int width = 486;

        int height = 486;
        drawAndSplit(g, x, y, width, height, 1);
    }

    public void drawAndSplit(Graphics g, int x, int y, int w, int h, int times)
    {
        if(times==levels) {
            g.fillRect(x,y,w,h);
        }
        else {
            int wid=w/3;
            int hei=h/3;
            drawAndSplit(g,x,y,wid,hei, times+1);
            drawAndSplit(g,x+2*wid,y,wid,hei, times+1);
            drawAndSplit(g,x+wid,y+hei,wid,hei, times+1);
            drawAndSplit(g,x+2*wid,y+2*hei,wid,hei, times+1);
            drawAndSplit(g,x,y+2*hei,wid,hei, times+1);
        }
    }

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 486, 486);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxFractal panel = new BoxFractal(6);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}