import java.util.HashMap;
/*
前缀和怎么用
 */
public class 和相同的二元子数组 {
    public static void main(String[] args) {

    }
}
class 七月八日 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(sum,map.getOrDefault(sum,0)+1);
            sum+=i;
            res+=map.getOrDefault(sum-goal,0);
        }
        return res;
    }
}
