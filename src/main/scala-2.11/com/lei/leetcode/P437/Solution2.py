class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        return self.dfs(root, sum, 0, {})

    def dfs(self, root, target, current, runningSum):
        if root is None:
            return 0
        current += root.val
        n = current - target
        pathCnt = 0

        if n in runningSum:
            pathCnt += runningSum[n]
        if current == target:
            pathCnt += 1

        if current in runningSum:
            runningSum[current] += 1
        else:
            runningSum[current] = 1

        t = pathCnt + self.dfs(root.left, target, current, runningSum) + self.dfs(root.right, target, current,
                                                                                  runningSum)
        # when return from the recursion, we need to remove the current sum value from runningSum.
        runningSum[current] -= 1
        return t
