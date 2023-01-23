package md.soft;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;


public abstract class AnimatedShape implements Runnable, ActionListener {
	protected Graphics2D buffer;
	protected Area area;
	protected AffineTransform aft;
	protected double dy;
	protected final int delay;
	protected  Color color;
	protected Shape shape;

	protected static final Random rand = new Random();

	public AnimatedShape(Graphics2D buffer, int delay) {
		this.buffer = buffer;
		this.delay = delay;
	}


	@Override
	public void run() {
		while (true) {
			shape = nextFrame();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException ignored) {
			}
		}
	}

	protected Shape nextFrame() {
		area = new Area(area);
		aft = new AffineTransform();
		aft.translate(0, dy);
		area.transform(aft);
		return area;
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		buffer.setColor(color.brighter());
		buffer.fill(shape);

		buffer.setColor(color.darker());
		buffer.draw(shape);
	}
}
