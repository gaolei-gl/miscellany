class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return

        left = 0
        right = len(nums)
        size = right
        while True:
            mid = left + (right - left) / 2
            if (mid == size - 1 or nums[mid] > nums[mid + 1] ) and (mid == 0 or nums[mid] > nums[mid - 1]):
                return mid
            if mid == 0 or nums[mid - 1] < nums[mid]:
                left = mid
            else:
                right = mid


if __name__ == '__main__':
    print Solution().findPeakElement([])
