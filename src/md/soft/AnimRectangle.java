package md.soft;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class AnimRectangle extends AnimatedShape {

    /**
     *
     * @param bufferG Graphics2D bufora
     * @param x współrzędna x
     * @param y współrzędna y
     * @param delay delay wątku
     * @param width szerokość
     * @param height wysokość
     */
    public AnimRectangle(Graphics2D bufferG, int x, int y, int delay, int width, int height) {
        super(bufferG, delay);
        color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)).brighter();
        shape = new Rectangle2D.Float(x, y, width, height);
        area = new Area(shape);
        Random random = new Random();
        dy = 5 + random.nextInt(5);
    }
}
