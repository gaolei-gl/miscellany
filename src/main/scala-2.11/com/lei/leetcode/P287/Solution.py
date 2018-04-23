class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        """
        Note:
            1. You must not modify the array (assume the array is read only).
            2. You must use only constant, O(1) extra space.
            3. Your runtime complexity should be less than O(n2).
            4. There is only one duplicate number in the array, but it could be repeated more than once.
        """

        lo = 1
        hi = len(nums) - 1
        while lo < hi:
            mid = lo + (hi - lo) / 2
            n = 0
            for i in nums:
                if i <= mid:
                    n += 1

            if n <= mid:
                lo = mid + 1
            else:
                hi = mid
        return lo


if __name__ == '__main__':
    print Solution().findDuplicate([3, 5, 1, 4, 4, 2, 4])
    print Solution().findDuplicate([1, 2, 3, 4, 4])
    print Solution().findDuplicate([1, 1])
