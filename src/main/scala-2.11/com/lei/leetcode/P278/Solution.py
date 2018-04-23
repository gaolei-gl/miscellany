# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

def isBadVersion(n):
    if n >= 1:
        return True
    else:
        return False


class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """

        if n == 1:
            return n if isBadVersion(n) else 0
        lo = 1
        hi = n

        while lo < hi:
            mid = lo + (hi - lo) / 2
            if isBadVersion(mid):
                hi = mid
            else:
                lo = mid + 1

        return lo


if __name__ == '__main__':
    print Solution().firstBadVersion(2)
