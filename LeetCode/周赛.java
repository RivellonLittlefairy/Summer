import java.util.*;
//运算次数超过10的八次方铁定超时
//以后注意算好复杂度再提交
public class 周赛 {
    public static int countPalindromicSubsequence(String s) {
        Set<String> res=new HashSet<>();
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ar=s.charAt(i);
            if(set.contains(ar)) continue;
            if(s.lastIndexOf(ar)==i) continue;
            char[] ars=new char[3];
            ars[0]=ar;
            ars[1]=ar;
            String str=s.substring(i+1,s.lastIndexOf(ar));
            for (int j = 0; j < 26; j++) {
                char ar2= (char) ('a'+j);
                if(str.indexOf(ar2)!=-1){
                    ars[2]=ar2;
                    res.add(new String(ars));
                }
            }
            set.add(ar);
        }
        return res.size();
        /*
            char ar='a'-1;
            while(ar++<'z'){
            if(s.indexOf(ar)==s.lastIndexOf(ar)) continue;
            char[] ars=new char[3];
            ars[0]=ar;
            ars[1]=ar;
            for(int i=s.indexOf(ar)+1;i<s.lastIndexOf(ar);i++){
                ars[2]=s.charAt(i);
                res.add(new String(ars));
            }
        }
        return res.size();

         */

    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] strs=text.split(" ");
        Set<Character> set=new HashSet<>();
        for(char ar:brokenLetters.toCharArray()){
            set.add(ar);
        }
        int res=0;
        for(String str:strs){
            boolean mark=false;
            for(char ar:str.toCharArray()){
                if(set.contains(ar)) {
                    mark=true;
                    break;
                }
            }
            if(!mark) res++;
        }
        return res;
    }
    public static int addRungs(int[] rungs, int dist) {
        int res=0;
        int dis=rungs[0];
        res+=dis/dist;
        if(dis%dist==0) res--;
        for (int i = 1; i <rungs.length; i++) {
            if(rungs[i]-rungs[i-1]<=dist) continue;
            dis=rungs[i]-rungs[i-1];
            res+=dis/dist;
            if(dis%dist==0) res--;
        }
        return res;
    }
    public static long maxPoints(int[][] points) {
        long dp[][]=new long[points.length][points[0].length];
        long[][] mark=new long[points.length][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                if(i==0) {
                    dp[i][j]=points[i][j];
                    mark[i][0]=Math.max(dp[i][j],mark[i][0]);
                    continue;
                }
                long max=0;
                for (int k = 0; k <points[0].length; k++) {
                    max= Math.max(max, dp[i - 1][k] - Math.abs(k - j));
                    if(max>=mark[i-1][0]+Math.abs(mark[i-1][1] - j)) break;
                }
                dp[i][j]=points[i][j]+max;
                mark[i][0]=Math.max(dp[i][j],mark[i][0]);
                if(dp[i][j]==mark[i][0]) mark[i][1]=j;
            }

        }
        long res=0;
        for(long a:dp[dp.length-1]){
            res=Math.max(res,a);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[][]=new int[100][1000];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                nums[i][j]=9999;
            }
        }
        System.out.println(maxPoints(nums));


    }
    }

