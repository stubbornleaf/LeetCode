public class Solution {
    public double pow(double x, int n) {
        boolean isNeg = false, isXNeg = false;
        if (n == 0) return 1;
        if (n < 0) {
            n *= -1;
            isNeg = true;
        }
        if (x < 0) {
            isXNeg = true;
        }
        
        int power = 1, index = 0;
        double tmp = x;
        ArrayList<Double> vals = new ArrayList<Double>();
        vals.add(x);
        
        while (power < n) {
            index++;
            power *= 2;
            if (power < 0) {
                power /= 2;
                index--;
                break;
            }
            tmp *= tmp;
            vals.add(tmp);
        }
        
        tmp = 1;
        int tmpN = n;
        while (tmpN > 0 && index >= 0) {
            if (tmpN >= power) {
                tmp *= vals.get(index);
                tmpN -= power;
            }
            power /= 2;
            index--;
        }
        
        if (isXNeg && n % 2 != 0 && tmp > 0) tmp *= -1;
        if (isNeg) return 1 / tmp;
        else return tmp;
    }
}
