
/**
 * Created by Harry Chou at 2019/5/7.
 */
import java.util.ArrayList;

public class PrintMatrixInSpiralOrder {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int topR = 0;
        int topC = 0;
        int bottomR = matrix.length - 1;
        int bottomC = matrix[0].length - 1;
        while (topR <= bottomR && topC <= bottomC) {
            list.addAll(oneLayer(matrix, topR++, topC++, bottomR--, bottomC--));
        }
        return list;
    }

    private static ArrayList<Integer> oneLayer(int[][] matrix, int topR, int topC, int bottomR, int bottomC) {
        ArrayList<Integer> oneLayerList = new ArrayList<>();
        if (topR == bottomR) {
            for (int i = topC; i <= bottomC; i++) {
                oneLayerList.add(matrix[topR][i]);
            }
        } else if (topC == bottomC) {
            for (int i = topR; i <= bottomR; i++) {
                oneLayerList.add(matrix[i][topC]);
            }
        } else {
            int currentR = topR;
            int currentC = topC;
            while (currentC != bottomC) {
                oneLayerList.add(matrix[topR][currentC++]);
            }
            while (currentR != bottomR) {
                oneLayerList.add(matrix[currentR++][bottomC]);
            }
            while (currentC != topC) {
                oneLayerList.add(matrix[bottomR][currentC--]);
            }
            while (currentR != topR) {
                oneLayerList.add(matrix[currentR--][topC]);
            }
        }
        return oneLayerList;
    }
}