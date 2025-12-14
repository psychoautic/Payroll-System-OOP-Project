import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Shift {
    private String shiftId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Shift(String shiftId, LocalDateTime startTime, LocalDateTime endTime) {
        this.shiftId = shiftId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getDurationHours() {
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        return minutes / 60.0;
    }

    public void getShiftDetails() {
        System.out.println("Shift ID: " + shiftId);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Duration (hours): " + getDurationHours());
    }

    @Override
    public String toString() {
        return "Shift [" + shiftId + "]: " + startTime + " to " + endTime;
    }
}