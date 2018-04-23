class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        if nums is None or len(nums) == 0:
            return -1
        idx = 0
        min = nums[idx]

        for i in xrange(len(nums)):
            if min > nums[i]:
                min = nums[i]
                idx = i

        left = self.binarySearch(nums[0:idx], target)
        right = self.binarySearch(nums[idx:], target)
        right = right + idx if right >= 0 else -1
        return max(left, right)

    def binarySearch(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return -1

        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        # End Condition: left > right
        return -1


if __name__ == '__main__':
    print Solution().search([3, 4, 5, 1, 2], 1)
