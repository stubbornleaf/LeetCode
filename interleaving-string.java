public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length(), index1, index2, index3;
        if ((length1 + length2) != length3) return false;
        
        boolean[][] result = new boolean[length2 + 1][length1 + 1];
        result[0][0] = true;
        for (index1 = 0, index3 = 0; index1 < length1; index1++, index3++) {
            if (s1.charAt(index1) == s3.charAt(index3)) {
                result[0][index1 + 1] = true;
            } else {
                break;
            }
        }
        for (index2 = 0, index3 = 0; index2 < length2; index2++, index3++) {
            if (s2.charAt(index2) == s3.charAt(index3)) {
                result[index2 + 1][0] = true;
            } else {
                break;
            }
        }
        
        for (index2 = 0; index2 < length2; index2++) {
            for (index1 = 0; index1 < length1; index1++) {
                if (s1.charAt(index1) == s3.charAt(index1 + index2 + 1)) {
                    result[index2 + 1][index1 + 1] |= result[index2 + 1][index1];
                }
                if (s2.charAt(index2) == s3.charAt(index1 + index2 + 1)) {
                    result[index2 + 1][index1 + 1] |= result[index2][index1 + 1];
                }
            }
        }
        
        return result[length2][length1];
    }
}
