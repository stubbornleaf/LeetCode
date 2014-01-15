public class Solution {
    public void nextPermutation(int[] num) {
        int index = num.length - 2, i = 0;
        for (; index >= 0; index--) {
            boolean hasBigger = false;
            for (i = index + 1; i < num.length; i++) {
                if (num[i] > num[index]) {
                    hasBigger = true;
                    break;
                }
            }
            if (hasBigger) break;
        }
        
        if (index >= 0) {
            int j = i;
            for (; j < num.length; j++) {
                if (num[index] >= num[j]) break;
            }
            int tmp = num[index];
            num[index] = num[j - 1];
            num[j - 1] = tmp;
            
            for (i = index + 1; i <= (num.length - 1 + index) / 2; i++) {
                tmp = num[i];
                num[i] = num[num.length - i + index];
                num[num.length - i + index] = tmp;
            }
        } else {
            for (i = 0; i < num.length / 2; i++) {
                int tmp = num[i];
                num[i] = num[num.length - 1 - i];
                num[num.length - 1 - i] = tmp;
            }
        }
    }
}
