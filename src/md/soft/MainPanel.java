package md.soft;

import md.soft.controlPanel.ControlPanel;
import md.soft.controlPanel.MainControlPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{

    public MainPanel() {
        setSize(500, 500);
        CanvaPanel canvaPanel = new CanvaPanel();
        canvaPanel.setLayout(null);
        addKeyListener(canvaPanel);
        setLayout(new BorderLayout());

        canvaPanel.setPreferredSize(new Dimension(1000, 500));


        ControlPanel horizontalControlPanel = new MainControlPanel(canvaPanel, JSlider.HORIZONTAL);
        ControlPanel verticalControlPanel = new ControlPanel(canvaPanel, JSlider.VERTICAL);
        add(canvaPanel, BorderLayout.CENTER);
        add(horizontalControlPanel, BorderLayout.SOUTH);
        add(verticalControlPanel, BorderLayout.WEST);
        SwingUtilities.invokeLater(canvaPanel::initialize);

    }
}
