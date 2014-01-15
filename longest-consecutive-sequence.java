public class Solution {
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
        int longest = 0;
        
        for (int index = 0; index < num.length; index++) {
            if (!lengthMap.containsKey(num[index])) lengthMap.put(num[index], -1);
        }
        
        for (int index = 0; index < num.length; index++) {
            if (lengthMap.get(num[index]) != -1) continue;
            
            int length = 1, tmp = num[index] + 1, top = num[index], bottom = num[index];
            boolean done = false;
            
            while (lengthMap.containsKey(new Integer(tmp))) {
                top = tmp;
                length++;
                tmp++;
            }
            
            tmp = num[index] - 1;
            while (lengthMap.containsKey(tmp)) {
                bottom = tmp;
                length++;
                tmp--;
            }
            
            if (length > longest) longest = length;
            
            for (int j = bottom; j <= top; j++) lengthMap.put(j, length);
        }
        
        return longest;
    }
}
