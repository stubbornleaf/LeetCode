public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<>();
        int start = 0, end = 0, count, charCount, wordsWithSpacesCount, spaces, tmp;
        
        while (start < words.length) {
            count = -1;
            charCount = 0;
            end = start;
            while (end < words.length && count <= L) {
                charCount += words[end].length();
                count += words[end].length() + 1;
                end++;
            }
            if (count > L) {
                charCount -= words[end - 1].length();
                end -= 2;
            }
            if (end == words.length) {
                end--;
            }
            
            StringBuilder line = new StringBuilder();
            if (end == words.length - 1) {
                for (int i = start; i < end; i++) {
                    line.append(words[i] + " ");
                }
                line.append(words[end]);
                for (int i = L - line.length(); i > 0; i--) {
                    line.append(" ");
                }
            } else {
                if ((end - start) == 0) {
                    line.append(words[start]);
                    tmp = L - charCount;
                    while (tmp-- > 0) {
                        line.append(" ");
                    }
                } else {
                    spaces = ((L - charCount) + (end - start - 1)) / (end - start);
                    wordsWithSpacesCount = end - start - (spaces * (end - start) - (L - charCount));
                    
                    for (int i = 0; i < wordsWithSpacesCount; i++) {
                        line.append(words[start + i]);
                        tmp = spaces;
                        while (tmp-- > 0) {
                            line.append(" ");
                        }
                    }
                    for (int i = start + wordsWithSpacesCount; i < end; i++) {
                        line.append(words[i]);
                        tmp = spaces - 1;
                        while (tmp-- > 0) {
                            line.append(" ");
                        }
                    }
                    line.append(words[end]);
                }
            }
            
            result.add(line.toString());
            start = end + 1;
        }
        
        return result;
    }
}
