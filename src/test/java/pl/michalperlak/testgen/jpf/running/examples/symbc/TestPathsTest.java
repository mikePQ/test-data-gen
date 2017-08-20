package pl.michalperlak.testgen.jpf.running.examples.symbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestPathsTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{2501, false}, {-2147483648, false}, {-2147483648, true}, {1200, true}, {1201, true}, {2500, true}});
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