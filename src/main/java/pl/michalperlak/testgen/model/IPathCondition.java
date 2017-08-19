package pl.michalperlak.testgen.model;

public interface IPathCondition {
    String getAsString();
    TestData solve();
    boolean overlaps(IPathCondition condition);
}
