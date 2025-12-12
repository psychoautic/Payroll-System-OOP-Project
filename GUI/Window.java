package GUI;

import javax.swing.JFrame;
import java.awt.Color;

public class Window extends JFrame {

    private final Color DARK_NAVY_BLUE = new Color(10, 30, 40);

    public Window() {
        // frame.setUndecorated(true);
        this.setTitle("Payroll Managment System");
        this.setSize(1980, 1080);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(DARK_NAVY_BLUE);
    }
}
