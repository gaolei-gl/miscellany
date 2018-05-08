# There are two sorted arrays nums1 and nums2 of size m and n respectively.
# Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

# https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation

class Solution(object):
    import sys
    MAX = sys.maxint
    MIN = -MAX

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        n1 = len(nums1)
        n2 = len(nums2)
        if n1 < n2:
            return self.findMedianSortedArrays(nums2, nums1)

        lo = 0
        hi = 2 * n2
        while lo <= hi:
            mid2 = (lo + hi) / 2
            mid1 = n1 + n2 - mid2

            l1 = self.MIN if mid1 == 0 else nums1[(mid1 - 1) / 2]
            l2 = self.MIN if mid2 == 0 else nums2[(mid2 - 1) / 2]

            r1 = self.MAX if mid1 == n1 * 2 else nums1[mid1 / 2]
            r2 = self.MAX if mid2 == n2 * 2 else nums2[mid2 / 2]

            if l1 > r2:
                lo = mid2 + 1
            elif l2 > r1:
                hi = mid2 - 1
            else:
                return float('%.2f' % ((max(l1, l2) + min(r1, r2)) / 2.0))


if __name__ == '__main__':
    # print Solution().findMedianSortedArrays([1, 3], [2])
    # print Solution().findMedianSortedArrays([1, 2], [3, 4])
    # print Solution().findMedianSortedArrays([], [3, 4])
    print Solution().findMedianSortedArrays([], [])
