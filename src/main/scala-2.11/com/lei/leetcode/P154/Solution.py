class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if nums is None:
            return
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return min(nums[0], nums[1])
        lo = 0
        hi = len(nums) - 1
        if nums[hi] > nums[lo]:
            return nums[lo]

        mid = lo + (hi - lo) / 2
        left = nums[lo] if (nums[lo] < nums[mid]) else self.findMin(nums[lo:mid])
        right = nums[mid] if (nums[mid] < nums[hi]) else self.findMin(nums[mid:hi + 1])
        return min(left, right)


if __name__ == '__main__':
    print Solution().findMin([1, 3, 3])
    print Solution().findMin([3, 3, 1, 3])
    print Solution().findMin([3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 2])
    print Solution().findMin([10, 1, 10, 10, 10])
