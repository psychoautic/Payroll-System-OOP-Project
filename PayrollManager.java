import java.util.ArrayList;

public class PayrollManager {

    private ArrayList<Employee> employeeList;

    public PayrollManager() {
        employeeList = new ArrayList<Employee>();
        for (int i = 0; i <= 3; i++) {
            employeeList.add(new Employee(353, "Eyad", "Mahmoud", 34));
        }
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

}
