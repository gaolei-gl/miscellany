class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        q = [0]
        origin_len = len(nums)
        nums = filter(lambda x: x != 0, nums)
        for i in xrange(len(nums)):
            size = len(q)
            for j in xrange(size):
                head = q.pop(0)
                q.append(head + nums[i])
                q.append(head - nums[i])

        return len(filter(lambda x: x == S, q)) * 2 ** (origin_len - len(nums))


if __name__ == '__main__':
    s = Solution()
    print s.findTargetSumWays([42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47], 38)
    print s.findTargetSumWays([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1], 1)
