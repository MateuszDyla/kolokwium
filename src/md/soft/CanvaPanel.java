package md.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CanvaPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
    BufferedImage buffer;
    Graphics2D screenG;
    Graphics2D bufferG;
    private final Timer timer;
    Point point1;
    Point point2;
    ArrayList<AnimRectangle> rectList = new ArrayList<>();
    Pixel pixel;
    int xPointer = 0;
    int yPointer = 0;

    public CanvaPanel() {
        super();
        timer = new Timer(70, this);
        setVisible(true);
        addMouseListener(this);
    }

    public void initialize() {
        buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        bufferG = (Graphics2D) buffer.getGraphics();
        bufferG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        screenG = (Graphics2D) getGraphics();
        screenG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        timer.start();

    }

    private void drawRectangle(Point point1, Point point2) {
        int width = Math.abs(point1.x - point2.x);
        int height = Math.abs(point1.y - point2.y);
        AnimRectangle rectangle = new AnimRectangle(bufferG, Math.min(point1.x, point2.x), Math.min(point1.y, point2.y), 70, width, height);
        rectList.add(rectangle);
        timer.addActionListener(rectangle);
        new Thread(rectangle).start();
    }

    private void drawPixel(Point point){
        pixel = new Pixel(bufferG, point.x, point.y, 1000);
        timer.addActionListener(pixel);
        new Thread(pixel).start();
    }

    public void shoot() {
        for (AnimRectangle rectangle: rectList) {
            if (isRectanglePointed(rectangle)) {
                timer.removeActionListener(rectangle);
            }
        }
    }

    private boolean isRectanglePointed(AnimRectangle rectangle) {
        Rectangle bounds = rectangle.area.getBounds();
        return xPointer > bounds.x && xPointer < bounds.x + bounds.getWidth()
                && yPointer > bounds.y && yPointer < bounds.y + bounds.getHeight();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        screenG.drawImage(buffer, 0, 0, null);
        bufferG.clearRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (point1==null) {
            point1 = new Point(e.getX(), e.getY());
            drawPixel(point1);
            return;
        }
        point2 = new Point(e.getX(), e.getY());
        drawRectangle(point1, point2);

        point1 = null;
        point2 = null;
        timer.removeActionListener(pixel);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void setxPointer(int xPointer) {
        this.xPointer = xPointer;
    }

    public void setyPointer(int yPointer) {
        this.yPointer = yPointer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        shoot();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
