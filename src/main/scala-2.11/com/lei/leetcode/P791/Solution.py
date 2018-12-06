class Solution(object):
    def customSortString(self, S, T):
        from collections import Counter
        res = []
        counter = Counter(T)
        for s in S:
            if s in counter:
                res.append(s * counter.pop(s))

        for s in counter.keys():
            res.append(s * counter.pop(s))
        return ''.join(res)


if __name__ == '__main__':
    s = Solution()
    print s.customSortString("hucw",
                             "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh")
