class Solution(object):
    def minDeletionSize(self, A):
        """
        :type A: List[str]
        :rtype: int
        """
        N = len(A)
        M = len(A[0])

        cur = [''] * N
        ans = 0
        for j in range(M):
            cur2 = cur[:]
            for i in range(N):
                cur2[i] = cur2[i] + A[i][j]
            if self._is_sorted(cur2):
                cur = cur2
            else:
                ans += 1
        return ans

    def _is_sorted(self, A):
        """
        :param A: List[str]
        :return: boolean
        """
        for i in range(len(A) - 1):
            if A[i] > A[i + 1]:
                return False
        return True


if __name__ == '__main__':
    s = Solution()
    # print s.minDeletionSize(['ca', 'bb', 'ac'])
    # print s.minDeletionSize(['xc', 'yb', 'za'])
    # print s.minDeletionSize(["xga", "xfb", "yfa"])
    # print s.minDeletionSize(['zyx', 'wvu', 'tsr'])
    print s.minDeletionSize(["abx", "agz", "bgc", "bfc"])
