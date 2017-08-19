package pl.michalperlak.testgen.model;

public class PathCondition {
    private final String condition;

    public PathCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return condition;
    }
}
