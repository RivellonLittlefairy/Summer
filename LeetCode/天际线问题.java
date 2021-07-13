import java.util.*;
//不会做，，第三个样例是[[0,2147483647,2147483647]]这让我开长数组模拟的情何以堪


/*

城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。

每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：

lefti 是第 i 座建筑物左边缘的 x 坐标。
righti 是第 i 座建筑物右边缘的 x 坐标。
heighti 是第 i 座建筑物的高度。
天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，
y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案
；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 */
public class 天际线问题 {
    static class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            int[] sky=new int[10000];
            int max=0;
            for(int[] threeNum:buildings){
                max=Math.max(max,threeNum[1]);
                for(int i=threeNum[0];i<=threeNum[1];i++){
                    sky[i]= Math.max(threeNum[2],sky[i]);
                }
            }
            List<List<Integer>> res=new LinkedList<>();
            if(sky[0]!=0){
                List<Integer> l=new LinkedList<>();
                l.add(0);
                l.add(sky[0]);
                res.add(l);
            }
            for(int i=1;i<=max+1;i++){
                if(sky[i]!=sky[i-1]){
                    List<Integer> l1=new LinkedList<>();
                    l1.add(i);
                    if(sky[i]<sky[i-1]) l1.set(0,l1.get(0)-1);
                    l1.add(sky[i]);
                    res.add(l1);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s1=new Solution();
        System.out.println(s1.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}
