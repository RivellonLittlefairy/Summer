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
        for(int i=0;i<points[0].length;i++){
            dp[0][i]=points[0][i];
        }
        for (int i = 1; i < points.length; i++) {
            long[] cur=new long[points.length];
            long lmax=0;
            for(int j=0;j<points[0].length;j++){
                lmax=Math.max(lmax-1,dp[i-1][j]);
                cur[j]=lmax;
            }
            long rmax=0;
            for(int j=points[0].length-1;j>=0;j--){
                rmax=Math.max(rmax-1,dp[i-1][j]);
                cur[j]=Math.max(cur[j],rmax);
            }
            for(int j=0;j<points[0].length;j++){
                dp[i][j]=dp[i-1][j]+cur[j];
            }
        }
        long res=0;
        for(long a:dp[dp.length-1]){
            res=Math.max(res,a);
        }
        return res;
    }
    public static int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int[] nums:adjacentPairs){
            if(map.containsKey(nums[0])){
                map.get(nums[0]).add(nums[1]);
                set.remove(nums[0]);
            }else{
                List<Integer> lis=new LinkedList<>();
                lis.add(nums[1]);
                map.put(nums[0],lis);
                set.add(nums[0]);
            }
            if(map.containsKey(nums[1])){
                map.get(nums[1]).add(nums[0]);
                set.remove(nums[1]);
            }else{
                List<Integer> lis=new LinkedList<>();
                lis.add(nums[0]);
                map.put(nums[1],lis);
                set.add(nums[1]);
            }
        }
        int[] res=new int[adjacentPairs.length+1];
        for(int i:set){
            res[0]=i;
        }
        res[1]=map.get(res[0]).get(0);
        for(int i=1;i<res.length-1;i++){
            int a=map.get(res[i]).get(0);
            int b=map.get(res[i]).get(1);
            res[i+1]=a==res[i-1]?b:a;
        }
        return res;
    }
    public static void main(String[] args) {
       int[][] a=new int[][]{{2,1},{3,4},{2,3}};
        System.out.println(restoreArray(a));



    }
    }

