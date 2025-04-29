package PersonProblem;

import java.util.ArrayList;
public class Person {
    ArrayList<Problem> problems = new ArrayList<>();

    private Problem problem;

    public void addProblem(Problem problem) {
        if (problem == null) {
            throw new NullPointerException("problem is null");
        }
        this.problems.add(problem);
    }

    public Problem solveProblem(Problem name) {
        for (Problem problem : problems) {
            if (problem.getName().equals(name.getName())) {
                problem.solve();
                return problem;
            }
        }
       throw new NullPointerException("Problem not solve");
    }


    public int unsolvedProblem() {
        for (Problem problem : problems) {
            if (!problem.isSolved()) {
                return problems.size();
            }
        }
        throw new NullPointerException("");
    }


}
