package PersonProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person person = new Person();

    @Test
    public void testAddProblem() {
        Problem problem1 = new Problem("Ojo", "Money matter", "Financial");
        Problem problem2 = new Problem("ojo", "Money matter", "Education");
        person.addProblem(problem1);
        person.addProblem(problem2);
        assertEquals("Financial", problem1.getType());
        assertEquals("Education", problem2.getType());
    }

    @Test
    public void testAddProblem_NullProblem() {
        assertThrows(NullPointerException.class, () -> person.addProblem(null));
    }

    @Test
    public void testSolvedProblem() {
        Problem problem1 = new Problem("Ojo", "Money matter", "Financial");
        person.addProblem(problem1);
        person.solveProblem(problem1);
        assertEquals(problem1, person.solveProblem(problem1));
    }

    @Test
    public void testUnSolvedProblem() {
        Problem problem1 = new Problem("Ojo", "Money matter", "Financial");
        Problem problem2 = new Problem("Ade", "Money matter", "Education");
        person.addProblem(problem1);
        person.addProblem(problem2);
        assertEquals(2, person.unsolvedProblem());
    }

}