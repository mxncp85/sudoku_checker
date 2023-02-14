public class sudoku_checker {
    public static void main(String[] args) {
        int[][] sudoku = { //example of a valid sudoku
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println("Sudoku number 1:");
        isSudokuValid(sudoku);

        int[][] sudoku2 = { //example of a non valid sudoku
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 7, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 9},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println("Sudoku number 2:");
        isSudokuValid(sudoku2);
    }

    public static boolean isSudokuValid(int[][] sudoku) {
        // check rows
        for (int i = 0; i < 9; i++) {
            if (!isRowValid(sudoku, i)) {
                System.out.println("Sudoku is not valid");
                return false;
            }
        }
        // check columns
        for (int i = 0; i < 9; i++) {
            if (!isColumnValid(sudoku, i)) {
                System.out.println("Sudoku is not valid");
                return false;
            }
        }
        // check 3x3 squares
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isSquareValid(sudoku, i, j)) {
                    System.out.println("Sudoku is not valid");
                    return false;
                }
            }
        }
        System.out.println("Sudoku is valid");
        return true;
    }

    private static boolean isRowValid(int[][] sudoku, int row) { //check if a row is valid or not
       boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
           if (sudoku[row][i] != 0) {
                if (seen[sudoku[row][i] - 1]) {
                   return false;
             }
             seen[sudoku[row][i] - 1] = true;
          }
        }
        return true;
    }

    private static boolean isColumnValid(int[][] sudoku, int column) { //check if a column is valid or not
       boolean[] seen = new boolean[9];
       for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] != 0) {
               if (seen[sudoku[i][column] - 1]) {
                    return false;
               }
               seen[sudoku[i][column] - 1] = true;
            }
        }
        return true;
    }

    private static boolean isSquareValid(int[][] sudoku, int row, int column) { //check if a 3x3 square is valid or not
        boolean[] seen = new boolean[9];
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (sudoku[i][j] != 0) {
                    if (seen[sudoku[i][j] - 1]) {
                        return false;
                    }
                    seen[sudoku[i][j] - 1] = true;
                }
            }
        }
        return true;
    }
}