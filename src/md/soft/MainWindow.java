package md.soft;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel mainPanel = new MainPanel();
        setContentPane(mainPanel);
        setResizable(false);
        addKeyListener(mainPanel.getKeyListeners()[0]);
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
