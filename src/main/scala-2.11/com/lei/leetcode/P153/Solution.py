class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None:
            return None
        if len(nums) <= 1:
            return nums[0]

        lo = 0
        hi = len(nums) - 1
        return self.find(nums, lo, hi)

    def find(self, nums, lo, hi):
        if hi - lo < 1:
            return nums[lo]
        mid = lo + (hi - lo) / 2
        if nums[mid] > nums[mid + 1]:
            return nums[mid + 1]
        else:
            a = self.find(nums, lo, mid)
            b = self.find(nums, mid + 1, hi)
            return min(a, b)


if __name__ == '__main__':
    print Solution().findMin([1])
