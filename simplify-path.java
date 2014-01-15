public class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < directories.length; i++) {
            if (directories[i].length() > 0) {
                if (directories[i].equals("..")) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else if (directories[i].equals(".")) {
                    
                } else {
                    stack.push(directories[i]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            String tmp = stack.pop();
            sb.insert(0, "/" + tmp);
        }
        
        if (sb.toString().length() == 0) return "/";
        
        return sb.toString();
    }
}
