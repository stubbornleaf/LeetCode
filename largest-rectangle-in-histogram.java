public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        
        int max = height[0];
        ArrayList<Integer> heights = new ArrayList<Integer>(), widths = new ArrayList<Integer>(), indexies = new ArrayList<Integer>();
        heights.add(height[0]);
        widths.add(1);
        indexies.add(0);
        
        for (int index = 1; index < height.length; index++) {
            int currentHeight = height[index];
            int lastShorter = -1;
            
            for (int i = heights.size() - 1; i >= 0; i--) {
                if (heights.get(i) >= currentHeight) {
                    if (heights.get(i) * (index - widths.get(i)) > max) max = heights.get(i) * (index - widths.get(i));
                    heights.remove(i);
                    widths.remove(i);
                    indexies.remove(i);
                } else {
                    lastShorter = indexies.get(i);
                    break;
                }
            }
            
            heights.add(currentHeight);
            widths.add(lastShorter + 1);
            indexies.add(index);
        }
        
        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i) * (height.length - widths.get(i)) > max) {
                max = heights.get(i) * (height.length - widths.get(i));
            }
        }
        
        return max;
    }
}
