class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """

        memo = dict()
        return self.dp(nums, S, [], 0, memo)

    def dp(self, nums, S, prefix, idx, memo):
        if idx == len(nums):
            return 1 if sum(prefix) == S else 0
        else:
            if '%s,%s' % (sum(prefix), idx) in memo:
                print 'hit'
                return memo['%s,%s' % (sum(prefix), idx)]
            prefix.append(nums[idx])
            a = self.dp(nums, S, prefix, idx + 1, memo)
            prefix.pop()
            prefix.append(-nums[idx])
            b = self.dp(nums, S, prefix, idx + 1, memo)
            prefix.pop()
            memo['%s,%s' % (sum(prefix), idx)] = a + b
            return memo['%s,%s' % (sum(prefix), idx)]


if __name__ == '__main__':
    s = Solution()
    print s.findTargetSumWays([1, 1, 1, 1, 1], 3)
    print s.findTargetSumWays([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1], 1)
    print s.findTargetSumWays([42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47], 38)
