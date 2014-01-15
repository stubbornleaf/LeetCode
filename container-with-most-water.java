public class Solution {
    public int maxArea(int[] height) {
        int first = 0, second = height.length - 1, max = 0;
        
        while (first < second) {
            int tmp = height[first] > height[second] ? height[second] : height[first];
            if ((second - first) * tmp > max) {
                max = (second - first) * tmp;
            }
            
            if (height[first] <= height[second]) {
                first++;
            } else {
                second--;
            }
        }
        
        return max;
    }
}
