import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Window;
import GUI.SideBar;
import GUI.Text;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class GUI {

    Window window;
    private final Color DARK_NAVY_BLUE = new Color(10, 30, 40);
    private final Color LIGHT_NAVY_BLUE = new Color(30, 50, 60);
    private final Color TESTER_COLOR = new Color(255, 0, 0);

    private JPanel dashboardContainer;
    private Text NoEmployees;

    public GUI(PayrollManager manager) {

        window = new Window();
        ImageIcon imageIcon = new ImageIcon("public/PayrollLogoBig.png");
        window.setIconImage(imageIcon.getImage());
        SideBar sideBar = new SideBar(window.getWidth() / 5, LIGHT_NAVY_BLUE);
        window.add(sideBar, BorderLayout.WEST);

        InitializeDashboardContainer();
        window.add(dashboardContainer, BorderLayout.EAST);

        NoEmployees = new Text(manager.getEmployeeList().size() + " Employees", LIGHT_NAVY_BLUE);
        dashboardContainer.add(NoEmployees, BorderLayout.CENTER);

    }

    public void setNumberOfEmployees(int count) {
        NoEmployees.setText(String.valueOf(count));
    }

    private void InitializeDashboardContainer() {
        dashboardContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dashboardContainer.setPreferredSize(new Dimension(window.getWidth() - (window.getWidth() / 5), 1));
        dashboardContainer.setVisible(true);
        dashboardContainer.setBackground(TESTER_COLOR);
        dashboardContainer.setOpaque(true);
    }
}
