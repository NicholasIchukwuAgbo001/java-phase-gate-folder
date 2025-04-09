import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualApp {

    private LocalDate date;
    private int mainCycleLength;
    private int mainPeriodLength;


    public void lastDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void cycleLength(int mainCycleLength) {
        this.mainCycleLength = mainCycleLength;
    }

    public void periodLength(int mainPeriodLength) {
        this.mainPeriodLength = mainPeriodLength;
    }

    public String predictNextPeriodDate() {
        LocalDate nextPeriodDate = date.plusDays(mainCycleLength);
        return nextPeriodDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String calculateOvulationDate() {
        LocalDate ovulationDate = date.plusDays(mainCycleLength / 2);
        return ovulationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String calculateFertileStartDate() {
        LocalDate fertileStartDate = date.plusDays(mainCycleLength / 2 - 5);
        LocalDate fertileEndDate = date.plusDays(mainCycleLength / 2);
        return fertileStartDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }




    public String calculateFertileEndDate() {
        LocalDate fertileEndDate = date.plusDays(mainCycleLength / 2);
        return fertileEndDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
