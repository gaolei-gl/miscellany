# Write an efficient algorithm that searches for a value in an m x n matrix.
# This matrix has the following properties:
#
# Integers in each row are sorted in ascending from left to right.
# Integers in each column are sorted in ascending from top to bottom.

# Given target = 5, return true.
#
# Given target = 20, return false.


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix is None or len(matrix) == 0:
            return False
        height = len(matrix)
        width = len(matrix[0])
        r = height - 1
        c = 0
        while r >= 0 and c < width:
            if matrix[r][c] == target:
                return True
            elif matrix[r][c] > target:
                r -= 1
            elif matrix[r][c] < target:
                c += 1

        return False


if __name__ == '__main__':
    test = [
        [1, 4, 7, 11, 15],
        [2, 5, 8, 12, 19],
        [3, 6, 9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
    ]

    s = Solution()
    print s.searchMatrix(test, 5)
    print s.searchMatrix(test, 20)
