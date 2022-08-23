/**
 * Created by Harry Chou at 2019/7/23.
 */
public class Robots {

	public int movingCount(int threshold, int rows, int cols) {
		boolean[][] flag = new boolean[rows][cols];
		return move(threshold, rows, cols, 0, 0, flag);
	}

	private int move(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] || sum(i) + sum(j) > threshold) {
			return 0;
		}
		flag[i][j] = true;
		return move(threshold, rows, cols, i + 1, j, flag) +
		       move(threshold, rows, cols, i, j + 1, flag) +
		       move(threshold, rows, cols, i - 1, j, flag) +
		       move(threshold, rows, cols, i, j - 1, flag) + 1;
	}

	private static int sum(int number) {
		int sum = 0;
		while (number != 0) {
			int n = number % 10;
			sum += n;
			number = (number - n) / 10;
		}
		return sum;
	}
}
