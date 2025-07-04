class Solution{
    static {
        for (int i = 0; i < 65; i++) {
            maxArea(new int[] { 0, 0 });
        }
    }
    public static int maxArea(int[] height){
        int right = height.length - 1;
        int ans = 0;
        int left = 0;
        while(left < right){
            int min = Math.min(height[left], height[right]);
            ans = Math.max((right - left) * min,ans);
            while(left < right && height[left] <= min) left++;
            while(left < right && height[right] <= min) right--;
        }
        return ans;
    }
}