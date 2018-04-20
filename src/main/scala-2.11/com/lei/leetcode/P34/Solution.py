class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        if nums is None:
            return
        if len(nums) == 0:
            return [-1, -1]
        idx = self.bs(nums, 0, len(nums) - 1, target)
        if idx == -1:
            return [-1, -1]
        i = idx
        j = idx
        while i > 0 and nums[i - 1] == target:
            i -= 1
        while j < len(nums) - 1 and nums[j + 1] == target:
            j += 1
        return [i, j]

    def bs(self, nums, start, end, target):
        if nums is None or len(nums) == 0:
            return -1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                end = mid
            else:
                start = mid

        if nums[start] == target: return start
        if nums[end] == target: return end
        return -1


if __name__ == '__main__':
    print Solution().searchRange([5, 7, 7, 8, 10], 6)
    print Solution().searchRange([8] * 5, 8)
