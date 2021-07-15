import java.util.Arrays;
//二分的n种写法

public class 二分题绝对差值和 {
}

class Solution {
    static int mod = 1000000007;
    int[] nums3;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        nums3 = nums1.clone();
        Arrays.sort(nums3);
        int n = nums1.length;
        int res = 0;
        int maxdis = 0;
        for (int i = 0; i < nums1.length; i++) {
            int oridis = Math.abs(nums1[i] - nums2[i]);
            int dis = oridis - Math.abs(erfen(nums2[i]) - nums2[i]);
            maxdis = Math.max(dis, maxdis);
            res = (oridis + res) + mod;
        }
        return (res - maxdis + mod) % mod;
    }

    //初见写的，思路是逐渐缩小范围到左右边界相邻，然后返回差值小的
    public int erfen(int n) {
        int left = 0;
        int right = nums3.length - 1;
        while (right - left > 1) {
            int mid = (right - left) / 2 + left;
            if (nums3[mid] == n) return n;
            if (n > nums3[mid]) left = mid;
            else right = mid;
        }
        return nums3[right] - n > n - nums3[left] ? nums3[left] : nums3[right];
    }

    //答案给的，学习一波感觉比我的好写出来
    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
