class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 1;
        double result = 0.0;
        int sum = 0;

        for (int t = 0; t < k; t++) {
            sum += nums[t];
        }
        result = (double) sum / k;

        int a = 0;
        for (int t = i; t < k; t++) {
            a += nums[t];
        }

        for (int j = k; j < nums.length; j++) {
            a += nums[j];
            double avg = (double) a / k;
            if (avg > result) {
                result = avg;
            }
            a -= nums[i];
            i++;
        }

        return result;
    }
}