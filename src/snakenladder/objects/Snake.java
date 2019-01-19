/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder.objects;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import snakenladder.resources.utils.Constants;
import snakenladder.resources.utils.GenUtils;

/**
 *
 * @author bayasys
 */
public class Snake extends SprintObject {

    cell from, to;

    public Snake(cell from, cell to, String name) {
        this.from = from;
        this.to = to;
        this.name = name;
        this.x = from.getX();
        this.y = from.getY();
        this.width = (to.getNo() - from.getNo()) * to.width;
        this.height = (to.getNo() - from.getNo()) * to.width;
    }

    public void draw(Graphics2D g2d) {
        try {
            Image img;
            switch (GenUtils.getRandomNumberInRange(1, 2)) {
                case 1:
                    img = ImageIO.read(Constants.SNAKE1);
                    break;
                case 2:
                    img = ImageIO.read(Constants.SNAKE2);
                    break;
                default:
                    img = ImageIO.read(Constants.SNAKE1);
            }
            g2d.drawImage(img, from.getX(), from.getY(), to.getX() - from.getX(), to.getY() - from.getY(), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
