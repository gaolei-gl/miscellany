class Solution(object):
    def isIdealPermutation(self, A):
        return all(abs(i - v) <= 1 for i, v in enumerate(A))


if __name__ == '__main__':
    solution = Solution()
    print solution.isIdealPermutation([1, 0, 2])
    print solution.isIdealPermutation([0, 1, 2])
    print solution.isIdealPermutation([1, 2, 0])
    print solution.isIdealPermutation([2, 1, 0])
