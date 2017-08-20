package pl.michalperlak.testgen.jpf.running.examples.symbc;

public class TestPaths {
    public static void main(String[] args) {
        new TestPaths().testMe2(0, true);
    }

    public void testMe2(int x, boolean b) {
        if (b) {
            if (x <= 1200) {
                System.out.println("  <= 1200");
            }
            if (x >= 1200) {
                System.out.println("  >= 1200");
            }
        } else {
            if (x <= 2500) {
                System.out.println("  <= 2500");
            }
            if (x >= 2500) {
                System.out.println("  >= 2500");
            }
        }
    }
}
