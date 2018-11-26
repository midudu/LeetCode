import java.util.Arrays;

class Test {

    private static int[] testReferenceType() {

        int[] result = {1,2};

        try {
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            result[1] = 3;
        }
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(testReferenceType()));
    }
}