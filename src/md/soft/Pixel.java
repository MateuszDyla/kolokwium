package md.soft;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

/**
    Czerwony kwadracik 5x5, używany w celu zasygnalizowania kliknięcia myszą
 */
public class Pixel extends AnimatedShape {

    public Pixel(Graphics2D bufferG, int x, int y, int delay) {
        super(bufferG, delay);
        shape = new Rectangle2D.Float(x, y, 5, 5);
        dy=0;
        color = Color.red;
        area = new Area(shape);
    }
}
