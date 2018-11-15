class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        if not grid or not grid[0]:
            return 0
        X = len(grid)
        Y = len(grid[0])

        weight = [[0] * Y] * X

        for x in range(0, X):
            for y in range(0, Y):
                weight[x][y] = self.get_weight(weight, x, y) + grid[x][y]
        return weight[X - 1][Y - 1]

    def get_weight(self, weight, x, y):
        if x == 0 and y == 0:
            return 0
        if x == 0:
            return weight[x][y - 1]
        elif y == 0:
            return weight[x - 1][y]
        return weight[x - 1][y] if weight[x - 1][y] < weight[x][y - 1] else weight[x][y - 1]
