from typing import List


def majorityElement(nums: List[int]) -> int:
    count = 0
    now = 0
    for i in nums:
        if count == 0: now = i
        if now == i:
            count += 1
        else:
            count -= 1
    return now if nums.count(now) * 2 > len(nums) else -1


print(majorityElement([1, 3, 3]))
