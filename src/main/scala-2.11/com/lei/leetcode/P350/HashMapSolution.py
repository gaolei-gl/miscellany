class HashMapSolution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        from collections import defaultdict
        d1 = defaultdict(int)
        for n1 in nums1:
            d1[n1] += 1
        answer = []
        for n2 in nums2:
            if n2 in d1 and d1[n2] > 0:
                answer.append(n2)
                d1[n2] -= 1
        return list(set(answer))


if __name__ == '__main__':
    print HashMapSolution().intersect([1, 2, 2, 1], [2, 2])
