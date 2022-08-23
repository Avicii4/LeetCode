/**
 * Created by Harry Chou at 2019/7/7.
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (B.length != 0) {
            B[0] = 1;
            for (int i = 1; i < B.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            for (int j = B.length - 1; j > 0; j--) {
                temp *= A[j];
                B[j - 1] *= temp;
            }
        }
        return B;
    }
}
