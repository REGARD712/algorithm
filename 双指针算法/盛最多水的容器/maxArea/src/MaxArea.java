public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int v = 0;
        int max = 0;

        // 双指针从两边到中间找容积最大的
        while (left < right) {
            v = Math.min(height[left],height[right]) * (right-left);
            max = Math.max(max,v);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        //  返回最大容积
        return max;
    }
}
