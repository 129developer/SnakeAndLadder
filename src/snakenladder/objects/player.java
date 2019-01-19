package snakenladder.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import snakenladder.resources.utils.Constants;

/**
 *
 * @author Mukil
 */
public class player {

    private String name;
    private Color color;
    private boolean started;
    private int position;
    private cell positionCell;

    public player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void draw(Graphics2D g2d) {
        try {
            Image img = ImageIO.read(Constants.LADDER);
            g2d.setColor(color);
            g2d.drawOval(positionCell.getX(), positionCell.getY(), 10, 10);
        } catch (IOException ex) {
            Logger.getLogger(Ladder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
