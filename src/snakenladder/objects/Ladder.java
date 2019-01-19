/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder.objects;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Line;
import javax.imageio.ImageIO;
import snakenladder.resources.utils.Constants;

/**
 *
 * @author bayasys
 */
public class Ladder extends SprintObject {

    cell from, to;

    public Ladder(cell from, cell to, String name) {
        this.from = from;
        this.to = to;
        this.name = name;
    }

    public void draw(Graphics2D g2d) {
        try {
            Image img = ImageIO.read(Constants.LADDER);
            g2d.setColor(Color.GREEN);
            g2d.setStroke(new BasicStroke(3));
            Line ln1 = new Line(from.getX() + from.width / 2, from.getY() + from.width / 2, to.getX() + from.width / 2, to.getY() - from.width / 2);
            Line ln2 = new Line(from.getX() + from.width / 2 + 30, from.getY() + from.width / 2, to.getX() + from.width / 2 + 30, to.getY() - from.width / 2);
            g2d.drawLine((int) ln1.getStartX(), (int) ln1.getStartY(), (int) ln1.getEndX(), (int) ln1.getEndY());
            g2d.drawLine((int) ln2.getStartX(), (int) ln2.getStartY(), (int) ln2.getEndX(), (int) ln2.getEndY());
            g2d.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(3));
            for (int i = from.getX(); i > to.getX(); i -= 10) {
                for (int j = from.getY(); j < to.getY(); j += 10) {
                    g2d.drawLine(i, j, i + 30, j);
                    System.out.println("x : " + i + " y : " + j + " x : " + i + 30 + " y : " + j);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Ladder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
