package GUI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class SideBar extends Box {

    private final int WIDTH = 1920 / 5;
    private final int HEIGHT = 1080;

    public SideBar(int width, Color color) {
        super(BoxLayout.Y_AXIS);
        this.setPreferredSize(new Dimension(width, 1));
        this.setVisible(true);
        this.setBackground(color);
        this.setOpaque(true);
        System.out.println("Sidebar launched");
    }
}
