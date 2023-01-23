package md.soft.controlPanel;

import md.soft.CanvaPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyListener;

public class ControlPanel extends JPanel implements ChangeListener {

    JSlider slider;
    int orientation;

    CanvaPanel canvaPanel;

    /**
     * Podstawowy controlPanel z samym JSLiderem.
     * @param canvaPanel JPanel sterowany
     * @param orientation orientacja controlPanelu
     */
    public ControlPanel(CanvaPanel canvaPanel, int orientation) {
        this.orientation = orientation;
        this.canvaPanel = canvaPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        slider = new JSlider(orientation, 0, 100, 0);
        slider.addChangeListener(this);
        add(slider);
        addKeyListeners(canvaPanel);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if (orientation == JSlider.HORIZONTAL) {
            canvaPanel.setxPointer((int)(slider.getValue()*0.01*canvaPanel.getWidth()));
        } else if (orientation == JSlider.VERTICAL) {
            canvaPanel.setyPointer(canvaPanel.getHeight() - (int)(slider.getValue()*0.01*canvaPanel.getHeight()));
        }
    }

    /**
     * Dodaje keyListener do wszystkich elementów tego JPanelu.
     * @param keyListener
     */
    private void addKeyListeners(KeyListener keyListener) {
        Component[] components = this.getComponents();
        for (Component component : components) {
            component.addKeyListener(keyListener);
        }
    }
}
