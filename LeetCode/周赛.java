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

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
}
