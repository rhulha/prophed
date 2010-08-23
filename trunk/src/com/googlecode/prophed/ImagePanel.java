/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.prophed;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Ray
 */
public class ImagePanel extends JPanel implements MouseMotionListener {

    private BufferedImage img;
    Color color = Color.WHITE;

    public ImagePanel() {
        this( new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB));
    }

    public ImagePanel(BufferedImage img) {
        this.img = img;
        calcSize();
        setLayout(null);
        addMouseMotionListener(this);
    }

    public void calcSize()
    {
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = img.getGraphics();
        g.setColor(color);
        g.drawRect(e.getX(), e.getY(), 1, 1);
        this.repaint(e.getX(), e.getY(), 2, 2);
    }

    public void mouseMoved(MouseEvent e) {
    }

    public Color getColor() {
        return color;
    }

    void setColor(Color newColor) {
        color = newColor;
        //img.getGraphics().setColor(color); // fails
    }

    public BufferedImage getImage() {
        return img;
    }

    public void setImage( BufferedImage img)
    {
        this.img = img;
    }

    public void cutTopLine() {
        BufferedImage bitemp = new BufferedImage( img.getWidth(), img.getHeight()-1, BufferedImage.TYPE_INT_ARGB);
        bitemp.getGraphics().drawImage(img, 0, -1, null);
        img = bitemp;
        calcSize();
    }

    public void cutLeftLine() {
        BufferedImage bitemp = new BufferedImage( img.getWidth()-1, img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        bitemp.getGraphics().drawImage(img, -1, 0, null);
        img = bitemp;
        calcSize();
    }

    public void cutRightLine() {
        BufferedImage bitemp = new BufferedImage( img.getWidth()-1, img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        bitemp.getGraphics().drawImage(img, 0, 0, null);
        img = bitemp;
        calcSize();
    }

    public void cutBottomLine() {
        BufferedImage bitemp = new BufferedImage( img.getWidth(), img.getHeight()-1, BufferedImage.TYPE_INT_ARGB);
        bitemp.getGraphics().drawImage(img, 0, 0, null);
        img = bitemp;
        calcSize();
    }
}
