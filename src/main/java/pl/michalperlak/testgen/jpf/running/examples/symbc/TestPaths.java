package pl.michalperlak.testgen.jpf.running.examples.symbc;

public class TestPaths {
    public static void main(String[] args) {

        System.out.println("!!!!!!!!!!!!!!! Start Testing! ");
//        testMe(42, false);
        (new TestPaths()).testMe2(0, true);
    }

    // how many tests do we need to cover all paths?
    public static void testMe(int x, boolean b) {
        System.out.println("x = " + x);
        if (x <= 1200) {
            System.out.println("  <= 1200");
        }
        if (x >= 1200) {
            System.out.println("  >= 1200");
        }
    }

    public void testMe2(int x, boolean b) {
        System.out.println("!!!!!!!!!!!!!!! First step! ");
        //System.out.println("x = " + x);
        if (b) {
            if (x <= 1200) {
                System.out.println("  <= 1200");
            }
            if (x >= 1200) {
                System.out.println("  >= 1200");
            }
        }
    }
}
