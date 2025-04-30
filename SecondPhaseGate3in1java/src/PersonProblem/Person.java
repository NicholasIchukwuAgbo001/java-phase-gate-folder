package PersonProblem;

import java.util.ArrayList;

public class Person {
    ArrayList<Problem> problems = new ArrayList<>();

    public void addProblem(String name, ProblemType problem) {
        if (problem == null) {
            throw new NullPointerException("problem is null");
        }
        Problem newProblem = new Problem(name, problem);
        this.problems.add(newProblem);
    }

    public void solveProblem(String name) {
        for (Problem problem : problems) {
            if (problem.getName().equals(name)) {
                problem.solve();
                return;
            }
        }
       throw new NullPointerException("Problem not solve");
    }


    public ArrayList<Problem> unsolvedProblem() {
        ArrayList<Problem> unsolved = new ArrayList<>();
        for (Problem problem : problems) {
            if (!problem.isSolved()) {
                unsolved.add(problem);
            }
        }
        return unsolved;
    }


}
