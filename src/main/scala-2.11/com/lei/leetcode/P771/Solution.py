class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """

        from collections import Counter
        stones = Counter(S)
        num = 0
        for j in J:
            if j in stones:
                num += stones.get(j)
        return num
