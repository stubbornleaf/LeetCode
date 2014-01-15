public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        if (rowIndex == 0) return result;
        
        for (int index = 2; index <= rowIndex + 1; index++) {
            result.add(1);
            for (int innerIndex = index - 2; innerIndex > 0; innerIndex--) {
                result.set(innerIndex, result.get(innerIndex) + result.get(innerIndex - 1));
            }
        }
        
        return result;
    }
}
