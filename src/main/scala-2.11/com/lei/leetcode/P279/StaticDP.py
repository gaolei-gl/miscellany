import sys

# 586 / 586 test cases passed. Runtime: 6554 ms
class Solution(object):

    def numSquares(self, n):
        cnt = [sys.maxint] * (n + 1)
        cnt[0] = 0
        cnt[1] = 1
        for i in range(1, n + 1):
            j = 1

            while j * j <= i:
                cnt[i] = min(cnt[i], 1 + cnt[i - j * j])
                j += 1
        return cnt[n]


if __name__ == '__main__':
    s = Solution()
    print s.numSquares(10)
