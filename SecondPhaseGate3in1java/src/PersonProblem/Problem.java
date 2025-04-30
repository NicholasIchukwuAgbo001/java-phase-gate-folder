package PersonProblem;

public class Problem {
    private final String name;

    private final ProblemType type;
    private boolean solved;

    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.solved = false;
    }

    public void solve() {
        this.solved = true;
    }

    public String getName() {
        return name;
    }

    public ProblemType getType() {
        return type;
    }

    public boolean isSolved() {
        return solved;
    }

}

