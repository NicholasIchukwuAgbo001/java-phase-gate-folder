package menstrualApp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualTracker {

    private LocalDate date;
    private int mainCycleLength;
    private int mainPeriodLength;

    public void lastDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void cycleLength(int mainCycleLength) {
        if(mainCycleLength < 21 || mainCycleLength > 35) {
            throw new IllegalArgumentException("\nCycle length must be between 21 and 35.");
        }
        this.mainCycleLength = mainCycleLength;
    }

    public void periodLength(int mainPeriodLength) {
        if(mainPeriodLength < 1 || mainPeriodLength > 7) {
            throw new IllegalArgumentException("\nPeriod length must be between 1 and 7.");
        }
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
        return fertileStartDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String calculateFertileEndDate() {
        LocalDate fertileEndDate = date.plusDays(mainCycleLength / 2);
        return fertileEndDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String safeStartDate() {
        LocalDate safeStart = date.plusDays(mainCycleLength + 6 );
        return safeStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String safeEndDate() {
        LocalDate safeEnd = date.plusDays(mainCycleLength + 23);
        return safeEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String safeEndDate2() {
        LocalDate safeEnd = date.plusDays(mainCycleLength + 29);
        return safeEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
