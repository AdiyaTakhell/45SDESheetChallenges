package day4.findReapeatingandMissingNumber;

public class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {

        int n = nums.length;
        long expectedSum = ((long) n * (n + 1)) / 2;
        long expectedSumOfSquares = (n * (n + 1) * (2L * n + 1)) / 6;


        long actualSum = 0;
        long actualSumOfSquares = 0;
        for(long num : nums) {
            actualSum += num;
            actualSumOfSquares += (num * num);
        }

        long sumDifference = expectedSum - actualSum;
        long squareSumDifference = (expectedSumOfSquares - actualSumOfSquares ) / sumDifference;

        int missingNumber = (int) ((sumDifference + squareSumDifference) / 2);
        int repeatingNumber = (int) (missingNumber - sumDifference);
        return new int[]{repeatingNumber, missingNumber};

    }
}
