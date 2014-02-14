public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if (numRows <= 0) return result;
        
        ArrayList<Integer> row = new ArrayList<>(), previousRow;
        row.add(1);
        result.add(row);
        
        for (int index = 2; index <= numRows; index++) {
            row = new ArrayList<>();
            previousRow = result.get(index - 2);
            row.add(1);
            
            for (int i = 1; i < index - 1; i++) {
                row.add(previousRow.get(i - 1) + previousRow.get(i));
            }
            
            row.add(1);
            result.add(row);
        }
        
        return result;
    }
}
