class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.permutation(res, [], nums)
        return res

    def permutation(self, res, prefix, nums):
        if len(prefix) == len(nums):
            res.append(prefix[:])
        else:
            for i in range(0, len(nums)):
                if nums[i] in prefix:
                    continue
                prefix.append(nums[i])
                self.permutation(res, prefix, nums)
                prefix.pop(len(prefix) - 1)


if __name__ == '__main__':
    s = Solution()
    print s.permute([1, 2, 3])
