package md.soft;

import javax.swing.*;


public class MainControlPanel extends ControlPanel{

    JButton jButton;

    /**
     * Panel z JSliderem i przyciskiem do strzelania
     * @param canvaPanel - panel sterowany
     * @param orientation - orientacja JPanelu
     */
    public MainControlPanel(CanvaPanel canvaPanel, int orientation) {
        super(canvaPanel, orientation);

        jButton = new JButton("[Spacja] Strzel");
        jButton.addActionListener(e->onBtnClicked());
        add(jButton);
    }

    private void onBtnClicked() {
        canvaPanel.shoot();
    }

}
