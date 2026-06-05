package day4.countInversion;

public class Solution {
    private long mergeAndCount(int[] arr, int[] temp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        long invCount = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (i = low; i <= high; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    private long mergeSortAndCount(int[] arr, int[] temp, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            count += mergeSortAndCount(arr, temp, low, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, high);
            count += mergeAndCount(arr, temp, low, mid, high);
        }
        return count;
    }

    public long numberOfInversions(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSortAndCount(nums, temp, 0, nums.length - 1);
    }
}
