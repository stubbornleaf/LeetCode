public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        ArrayList<Integer> lastRow = triangle.get(triangle.size() - 1);
        Integer[] tmpSums = lastRow.toArray(new Integer[lastRow.size() - 1]);
        
        for (int index = triangle.size() - 2; index >= 0; index--) {
            ArrayList<Integer> row = triangle.get(index);
            for (int inner = 0; inner <= index; inner++) {
                tmpSums[inner] = tmpSums[inner] < tmpSums[inner + 1] ? tmpSums[inner] + row.get(inner) : tmpSums[inner + 1] + row.get(inner);
            }
        }
        
        return tmpSums[0];
    }
}
