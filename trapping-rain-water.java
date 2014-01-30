public class Solution {
    public int trap(int[] A) {
        class Info {
            int height;
            int startHeight;
            int length;
            Info (int height, int startHeight, int length) {
                this.height = height;
                this.startHeight = startHeight;
                this.length = length;
            }
        }
        
        int total = 0;
        ArrayList<Info> infos = new ArrayList<Info>();
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < infos.size(); j++) {
                Info info = infos.get(j);
                if (info.height <= A[i]) {
                    total += (info.height - info.startHeight) * info.length;
                    infos.remove(info);
                    j--;
                } else {
                    if (info.startHeight < A[i]) {
                        total += (A[i] - info.startHeight) * info.length;
                        info.startHeight = A[i];
                    }
                    info.length++;
                }
            }
            infos.add(new Info(A[i], 0, 0));
        }
        
        return total;
    }
}
