from typing import List

#前缀和是用来求一段连续区间值等于目标的算法
#常用于求数组的定值子数组和或者树的某个区间之和为定值
#思想是一次遍历数组（树）用map存下0-1，0-2，0-3的所有值
#再判断map中，也就是之前是否出现过前缀和为target-目前和的值，
#如果有，则 target-当前和 对应的值即为符合条件且尾为目前坐标的区间数量
def subarraySum(nums: List[int], k: int) -> int:
    map = {0: 1}
    sum = 0
    res = 0
    for i in nums:
        sum += i
        if sum - k in map: res += map[sum - k]
        if sum in map:
            map[sum] = map[sum] + 1
        else:
            map[sum] = 1
    return res


print(subarraySum([1], 0))


def numberOfSubarrays(nums: List[int], k: int) -> int:
    map = {0: 1}
    sum = 0
    res = 0
    for i in nums:
        if i % 2 == 1: sum += 1
        if sum-k in map: res += map[k - sum]
        if sum in map:
            map[sum] += 1
        else:
            map[sum] = 1
    return res


print(numberOfSubarrays([1, 1, 2, 1, 1], 3))
