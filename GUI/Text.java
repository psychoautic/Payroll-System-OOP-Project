package GUI;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Text extends JLabel {

    public Text(String text, Color color) {
        this.setText(text);
        this.setForeground(color);
        this.setFont(new Font("Cal Sans", Font.BOLD, 20));
    }
}
