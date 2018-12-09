class Solution(object):
    def canReorderDoubled(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        from collections import Counter
        counter = Counter(A)
        A.sort(key=abs)
        for front_num in A:
            if counter.get(front_num) <= 0:
                continue
            end_num = 2 * front_num
            cnt = counter.get(end_num)
            if cnt is None:
                continue
            counter[front_num] -= 1
            counter[end_num] -= 1
        s = map(lambda x: x == 0, counter.values())
        return all(s)


if __name__ == '__main__':
    s = Solution()
    print s.canReorderDoubled([3, 1, 3, 6])
    print s.canReorderDoubled([2, 1, 2, 6])
    print s.canReorderDoubled([4, -2, 2, -4])
    print s.canReorderDoubled([1, 2, 4, 16, 8, 4])
    print s.canReorderDoubled([1, 2, 1, -8, 8, -4, 4, -4, 2, -2])
