package day1.pascalTraingle;

class Solution {
    public int pascalTriangleI(int r, int c) {
        long result = 1;

        int row = r - 1;
        int col = c - 1;

        for (int i = 0; i < col; i++) {
            result = result * (row - i);
            result = result / (i + 1);
        }

        return (int) result;
    }
}
