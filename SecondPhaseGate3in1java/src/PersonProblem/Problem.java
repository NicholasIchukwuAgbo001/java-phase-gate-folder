package PersonProblem;

public class Problem {
    private final String name;
    private final String description;
    private final String type;
    private boolean solved;

    public Problem(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.solved = false;
    }

    public void solve() {
        this.solved = true;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isSolved() {
        return solved;
    }

    public String getDescription() {
        return description;
    }
}

