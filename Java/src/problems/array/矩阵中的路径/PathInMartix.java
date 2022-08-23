/**
 * Created by Harry Chou at 2019/7/23.
 */
public class PathInMartix {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] flag = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (find(matrix, rows, cols, str, i, j, flag, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean find(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] flag, int strIndex) {
		int matrixIndex = i * cols + j;
		// 不符合条件的，直接回退
		if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[matrixIndex] != str[strIndex] || flag[matrixIndex]) {
			return false;
		}
		// 寻找到最后，得出正确结果
		if (strIndex == str.length - 1) {
			return true;
		}
		// 路径中加入此位置
		flag[matrixIndex] = true;
		// 四个方向上寻找路径
		if (find(matrix, rows, cols, str, i + 1, j, flag, strIndex + 1) ||
		        find(matrix, rows, cols, str, i - 1, j, flag, strIndex + 1) ||
		        find(matrix, rows, cols, str, i, j + 1, flag, strIndex + 1) ||
		        find(matrix, rows, cols, str, i, j - 1, flag, strIndex + 1)) {
			return true;
		}
		// 此路不通，回溯，flag还原为false
		flag[matrixIndex] = false;
		return false;
	}

	public static void main(String[] args) {
		char[] matrix = new char[] {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
		char[] str = new char[] {'b', 'c', 'c', 'e', 'd'};
		boolean result = new pathInMartix().hasPath(matrix, 3, 4, str);
		System.out.println(result);
	}
}
