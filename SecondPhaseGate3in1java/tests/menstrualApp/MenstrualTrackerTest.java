package menstrualApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenstrualTrackerTest {

    MenstrualTracker menstrualApp = new MenstrualTracker();

    @Test
    public void testToPredictNextPeriodDateOf28Days() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-29", menstrualApp.predictNextPeriodDate());
    }

    @Test
    public void testToPredictNextPeriodDateOf30Days() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(30);
        menstrualApp.periodLength(5);
        assertEquals("2025-05-01", menstrualApp.predictNextPeriodDate());
    }

    @Test
    public void testToCalculateOvulationDateOf28Days() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-15", menstrualApp.calculateOvulationDate());
    }

    @Test
    public void testCalculateOvulationDate30Days() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(30);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-16", menstrualApp.calculateOvulationDate());
    }

    @Test
    public void testToCalculateFertileStartDate() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-10", menstrualApp.calculateFertileStartDate());
    }

    @Test
    public void testToCalculateFertileEndDate() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-15", menstrualApp.calculateFertileEndDate());
    }

    @Test
    public void testToCalculateSafeStartDate() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-05-05", menstrualApp.safeStartDate());
    }

    @Test
    public void testToCalculateSafeEndDate() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-23", menstrualApp.safeEndDate());
    }

}
