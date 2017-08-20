package pl.michalperlak.testgen.jpf.running.examples.symbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestPathsTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {{0, false}});
    }

    private int x;
    private boolean b;

    public TestPathsTest(int x, boolean b) {
        this.x = x;
        this.b = b;
    }

    @Test
    public void testMethod() {
        TestPaths testPaths = new TestPaths();
        testPaths.testMe2(x, b);
    }
}