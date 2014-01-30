public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int tmp = 0, total = ratings.length;
        
        for (int i = 0; i < candies.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = tmp++;
            } else {
                tmp = 1;
            }
        }
        
        for (int i = candies.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i] > tmp ? candies[i] : tmp;
                tmp++;
            } else {
                tmp = 1;
            }
        }
        
        for (int i = 0; i < candies.length; i++) {
            total += candies[i];
        }
        
        return total;
    }
}
