from typing import List


def countPairs(self, deliciousness: List[int]) -> int:
    mod = 1000000007
    maxVal = 0
    for i in deliciousness: maxVal = max(maxVal, i)
    map1 = {}
    count = 0;
    for i in deliciousness:
        j = 1
        while j <= maxVal * 2:
            if j - i in map1:
                count = (count + map1[j - i]) % mod
            j *= 2
        if i in map1:
            map1[i] = map1[i] + 1
        else:
            map1[i] = 1
    return count
