class Solution(object):
    def splitIntoFibonacci(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        if S is None or len(S) < 3:
            return []

        for i in xrange(min(10, len(S))):
            x = S[:i + 1]
            if x != '0' and x.startswith('0'):
                break
            a = int(x)
            for j in xrange(i + 1, min(10, len(S))):
                y = S[i + 1: j + 1]
                if y != '0' and y.startswith('0'):
                    break
                b = int(y)
                c = a + b
                z = str(c)
                k = j + 1
                fib = [a, b]
                while k < len(S):
                    if c < 2 ** 31 - 1 and S[k:len(z) + k] == z:
                        fib.append(c)
                        k += len(z)
                        c = fib[-1] + fib[-2]
                        z = str(c)
                    else:
                        break

                else:
                    if len(fib) >= 3:
                        return fib
        return []


if __name__ == '__main__':
    s = Solution()
    print s.splitIntoFibonacci("123456579")
