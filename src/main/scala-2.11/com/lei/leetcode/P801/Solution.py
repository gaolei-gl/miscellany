class Solution(object):
    def minSwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        no_swap = [0] * len(A)
        swap = [0] * len(A)
        swap[0] = 1
        for i in range(1, len(A)):
            if A[i - 1] < A[i] and B[i - 1] < B[i] and A[i - 1] < B[i] and B[i - 1] < A[i]:
                no_swap[i] = min(swap[i - 1], no_swap[i - 1])
                swap[i] = min(swap[i - 1], no_swap[i - 1]) + 1
            elif A[i - 1] < A[i] and B[i - 1] < B[i]:
                no_swap[i] = no_swap[i - 1]
                swap[i] = swap[i - 1] + 1
            elif A[i - 1] < B[i] and B[i - 1] < A[i]:
                no_swap[i] = swap[i - 1]
                swap[i] = no_swap[i - 1] + 1

        return min(swap[len(A) - 1], no_swap[len(A) - 1])


if __name__ == '__main__':
    s = Solution()
    print s.minSwap([0, 3, 5, 8, 9], [2, 1, 4, 6, 9])
