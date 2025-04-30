package PersonProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person person = new Person();


    @Test
    public void testAddProblem() {
        person.addProblem("SPIRITUAL", ProblemType.SPIRITUAL);
        assertEquals(1, person.unsolvedProblem().size());
    }

    @Test
    public void testAddProblem_NullProblem() {
        assertThrows(NullPointerException.class, () -> person.addProblem("Spiritual", null));
    }

    @Test
    public void testSolvedProblem() {
        person.addProblem("SPIRITUAL", ProblemType.SPIRITUAL);
        String problem = String.valueOf(person.unsolvedProblem());
        person.solveProblem(problem);
        assertEquals(1, person.unsolvedProblem().size());
    }


    @Test
    public void testUnSolvedProblem() {
        person.addProblem("SPIRITUAL", ProblemType.SPIRITUAL);
        assertEquals(1, person.unsolvedProblem().size());
    }


}