import java.util.HashMap;
/*
这道题类似于两数之和
不同的地方在于
1.数组数字可能重复
2.不能暴力解，只能用哈希表
难点
1.注意数组中的两数之和最大值即是2的幂上限
 */
/*
Py练习心得
1.map取数改数都用[]
2.py map的contains方法可以用
var in dict  来判断
 */
public class 大餐计数 {
    public static void main(String[] args) {
        七月七日 exam=new 七月七日();
        System.out.println(exam.countPairs(new int[]{1,1,1,3,3,3,7}));

    }
}
/*
大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
你可以搭配 任意 两道餐品做一顿大餐。
给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，
返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。

*/
class 七月七日 {
    static int mod=1000000007;
    public int countPairs(int[] deliciousness) {
        int res=0;
        int max=0;
        for(int i:deliciousness){
            max=Math.max(max,i);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:deliciousness){
            for(int j=1;j<=max*2;j*=2){
                if(map.containsKey(j-i)){
                    res=(res+map.get(j-i))%mod;
                }

            }
            map.put(i,map.containsKey(i)?map.get(i)+1:1);
        }
        return res;
    }
}
/*
Python代码
class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        mod=1000000007
        maxVal=0
        for i in deliciousness: maxVal=max(maxVal,i)
        map1={}
        count=0;
        for i in deliciousness:
            j=1
            while j<=maxVal*2:
                if j-i in map1:
                    count=(count+map1[j-i])%mod
                j*=2
            if i in map1:map1[i]=map1[i]+1
            else:map1[i]=1
        return count
 */