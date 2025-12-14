import java.time.LocalDateTime;
import java.util.List;

public class ShiftManager {
    private List<Shift> allShifts;



    public Shift createShift(String shiftId, LocalDateTime startTime, LocalDateTime endTime) {
        Shift newShift = new Shift(shiftId, startTime, endTime);
        allShifts.add(newShift);
        return newShift;
    }

    public void assignShift(Employee employee, Shift shift) {
        // Logic to assign the shift to the employee
        employee.addShift(shift);
        System.out.println("Assigned shift " + shift + " to employee " + employee.getFirstName() + " " + employee.getLastName());

    }

}
