// https://neetcode.io/problems/search-2d-matrix

// O(log m + log n)
class Solution {
    public int[] findArray(int[][] matrix, int target) {
        int top = 0, bot = matrix.length - 1;

        while(top <= bot) {
            int row = (top + bot) / 2;
            int[] arr = matrix[row];

            if (target > arr[arr.length - 1]) top = row + 1;
            else if (target < arr[0]) bot = row - 1;

            else break;
        }

        int row = (top + bot) / 2;

        return (top <= bot)? matrix[row] : null;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = findArray(matrix, target);

        if (arr == null) return false; 

        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int t = (l + r) / 2;

            if (target > arr[t]) l = t + 1; 
            else if (target < arr[t]) r = t - 1;

            else return true;
        }
        
        return false;
    }
}
