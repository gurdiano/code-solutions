// https://neetcode.io/problems/valid-sudoku/question

// O(n²)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Integer>> rows = new HashMap<>();
        Map<Integer, HashSet<Integer>> columns = new HashMap<>();
        Map<String, HashSet<Integer>> squares = new HashMap<>();

        int matrixSize = 9;
        int squareSize = 3;

        for(int row = 0; row < matrixSize; row++) {
            for(int column = 0; column < matrixSize; column++) {
                if(!Character.isDigit(board[row][column])) continue;

                int value = board[row][column];
                String square = (row / squareSize) + "" + (column / squareSize);


                if(rows.computeIfAbsent(row, set -> new HashSet<>()).contains(value)) return false;
                if(columns.computeIfAbsent(column, set -> new HashSet<>()).contains(value)) return false;
                if(squares.computeIfAbsent(square, set -> new HashSet<>()).contains(value)) return false;

                rows.get(row).add(value);
                columns.get(column).add(value);
                squares.get(square).add(value);
            }
        }

        return true;
    }
}
 