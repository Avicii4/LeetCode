import java.util.HashSet;

/**
 * Created by Harry Chou at 2018/10/20.
 * Description: Determine if a 9x9 Sudoku board is valid.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> Row = new HashSet<>();
            HashSet<Character> Column = new HashSet<>();
            HashSet<Character> Cell = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // check each row
                if (board[i][j] != '.' && !Row.add(board[i][j]))
                    return false;
                // check each column
                if (board[j][i] != '.' && !Column.add(board[j][i]))
                    return false;
                int rowNum = 3 * (i / 3) + j / 3;
                int columnNum = 3 * (i % 3) + j % 3;
                // check each cell
                if (board[rowNum][columnNum] != '.' && !Cell.add(board[rowNum][columnNum]))
                    return false;
            }
        }
        return true;
    }
}
