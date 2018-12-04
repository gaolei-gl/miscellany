class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        nums = [int(c) for c in str(N)]
        for i in xrange(len(nums) - 1):
            if nums[i] < nums[i + 1]:
                while i > 0 and nums[i] == nums[i - 1]:
                    i -= 1
                nums[i] -= 1
                i += 1
                while i < len(nums):
                    nums[i] = 9
                    i += 1
                break
        return self.to_num(nums)

    def to_num(self, nums):
        return int(''.join(map(str, nums)))


if __name__ == '__main__':
    solution = Solution()
    print solution.monotoneIncreasingDigits("332")
    print solution.monotoneIncreasingDigits("10")
    print solution.monotoneIncreasingDigits("9")
    print solution.monotoneIncreasingDigits("11")
    print solution.monotoneIncreasingDigits("6324")
    print solution.monotoneIncreasingDigits("365324")
    print solution.monotoneIncreasingDigits("369")
