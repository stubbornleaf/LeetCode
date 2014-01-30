public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int power = 1;
        int[] taken = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        
        taken[n] = 0;
        for (int i = n - 1; i >= 1; i--) {
            power *= i;
            taken[i] = 0;
        }
        
        for (int i = n; i >= 2; i--) {
            int tmp = k / power;
            k %= power;
            power /= (i - 1);
            
            int m = 1;
            while (taken[m] == 1) m++;
            
            for (int j = 0; j <= (tmp - 1) && m <= n; j++) {
                m++;
                while (taken[m] == 1) m++;
            }
            
            taken[m] = 1;
            sb.append(m);
        }
        
        int m = 1;
        while (taken[m] == 1) m++;
        sb.append(m);
        
        return sb.toString();
    }
}
