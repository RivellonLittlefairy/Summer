import java.util.Arrays;

public class 二分复习 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,4,6,6,10};
        Arrays.sort(nums);
        System.out.println(findLeft(nums,6));
    }
    //标准二分，优点是写起来简单不用想太多，缺点是当寻找的数字有多次重复时候并不能找到边界值
    public static int normal(int[] nums,int n){
        int l=0;
        int h=nums.length-1;
        if(nums[h]<n) return -1;
        //while里面能不能取等于由右边界决定，如果右边闭区间就取等于
        //原因是如果左闭右闭，搜索的区间就包括了两个边界，当l=n的时候，也要对这个元素进行搜索所以加上等于
        //例如数组中只有一个1，不加等于号就不会进行搜索直接返回-1
        while(l<=h){
            int mid=(h-l)/2+l;
            if(nums[mid]==n)
                return n;
            //因为一开始搜索区间是左闭右闭的，所以当下标为mid的值不等于时候就不用放入搜索区间了
            if(nums[mid]>n)
                h=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
    //改进版1假设要找到最左边出现的值
    public static int findLeft(int[] nums,int t){
        int l=0;
        int h=nums.length;
        //左闭右开的搜索区间，当l==h时搜索区间为空，因此不必考虑
        while(l<h){
            int mid=(h-l)/2+l;
            //当中间值是目标值，可以将搜索区间设置为【l，mid）这样能找到左边有没有目标值
            //目标值在左边的时候h设置成mid，因为右开
            if(nums[mid]>=t)
                h=mid;
            else
                l=mid+1;
        }
        if(nums[l]==t) return l;
        return -1;
    }
}
