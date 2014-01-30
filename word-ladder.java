public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        class Info {
            String s;
            int steps;
            
            Info(String s, int steps) {
                this.s = s;
                this.steps = steps;
            }
        }
        
        LinkedList<Info> queue = new LinkedList<Info>();
        HashSet<String> visited = new HashSet<String>();
        dict.add(end);
        
        queue.offer(new Info(start, 0));
        while (queue.size() > 0) {
            Info info = queue.poll();
            String s = info.s;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    if (s.charAt(i) != 'a' + j) {
                        String tmp = s.substring(0, i) + (char)('a' + j) + s.substring(i + 1, s.length());
                        if (dict.contains(tmp)) {
                            if (tmp.equals(end)) {
                                return info.steps + 2;
                            }
                            if (!visited.contains(tmp)) {
                                queue.offer(new Info(tmp, info.steps + 1));
                                visited.add(tmp);
                            }
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
