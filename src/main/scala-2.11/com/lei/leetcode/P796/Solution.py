class Solution(object):
    def rotateString(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if A == B:
            return True
        if len(A) != len(B):
            return False
        if len(A) == 0 or len(B) == 0:
            return False
        head = A[0]
        idxs = []
        b = B
        idx = b.find(head)
        while idx != -1:
            idxs.append(idx)
            b = b[idx + 1:]
            idx = b.find(head)
        #
        # for i in idxs:
        #     A[:i] + A[]


class BruteSolution(object):
    def rotateString(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: bool
        """
        if a == b:
            return True
        if len(a) != len(b):
            return False
        if len(a) == 0 or len(b) == 0:
            return False

        times = len(a)
        i = 1
        while i < times:
            part1 = a[:i]
            newStr = a[i:] + part1
            i += 1
            if newStr == b:
                return True
        return False


if __name__ == '__main__':
    s = BruteSolution()
    a = "abcde"
    b = "cdeab"
    print s.rotateString(a, b)
