import java.util.ArrayList;

public class ExecuteProgram {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            PayrollManager manager = new PayrollManager();
            GUI gui = new GUI(manager);
            // gui.setNumberOfEmployees(50);
        });
    }

}
