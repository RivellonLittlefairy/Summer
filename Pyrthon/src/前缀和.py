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
