from typing import List


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
