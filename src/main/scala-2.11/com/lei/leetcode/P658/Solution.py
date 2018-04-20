class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if len(arr) == 0:
            return
        lo = 0
        hi = len(arr) - k
        while lo < hi:
            mid = lo + (hi - lo) / 2
            if x - arr[mid] > arr[mid + k] - x:
                lo = mid + 1
            else:
                hi = mid

        return arr[lo:lo + k]


if __name__ == '__main__':
    print Solution().findClosestElements([1, 2, 5, 7, 10, 12, 15], 3, 8)
