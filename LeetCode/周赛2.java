import java.util.HashSet;
import java.util.Set;
//7.25周赛，，这场打的巨烂无比
public class 周赛2 {
    public static int getLucky(String s, int k) {
        StringBuffer num = new StringBuffer();
        for (char ar : s.toCharArray()) {
            int n = ar - 'a' + 1;
            num.append(n);
        }
        String n = num.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char ar : n.toCharArray()) {
                sum += (ar - '0');
            }
            n = sum + "";

        }
        return Integer.valueOf(n);
    }

    public static String maximumNumber(String num, int[] change) {
        StringBuilder builder = new StringBuilder(num);
        boolean mark = false;
        for (int i = 0; i < num.length(); i++) {
            char ar = num.charAt(i);
            int n = ar - '0';
            if (n == change[n]) continue;
            if (n > change[n]) {
                if (mark) {
                    break;
                } else {
                    continue;
                }
            }
            builder.replace(i, i + 1, change[n] + "");
            mark = true;

        }
        return builder.toString();
    }

    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(maxCompatibilitySum(new int[][]{{0,0,1,1,1,0,1},{0,1,1,0,0,0,0},{0,0,1,1,1,1,1},{0,1,0,0,1,0,1},{1,0,1,1,1,1,1}},
                new int[][]{{0,1,1,0,0,0,0},{0,1,0,0,0,0,1},{0,1,0,1,0,0,1},{1,0,0,0,1,0,1},{1,1,1,1,1,0,0}}));
    }
}
