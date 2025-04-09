import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MenstrualAppTest {
   MenstrualApp menstrualApp = new MenstrualApp();

    @Test
    public void testToPredictNextPeriodDate() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-29", menstrualApp.predictNextPeriodDate());
    }

    @Test
    public void testToCalculateOvulationDate() {
        menstrualApp.lastDate("2025-04-01");
        menstrualApp.cycleLength(28);
        menstrualApp.periodLength(5);
        assertEquals("2025-04-15", menstrualApp.calculateOvulationDate());
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


}
