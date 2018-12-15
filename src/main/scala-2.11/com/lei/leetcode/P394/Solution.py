class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        for ch in s:
            if ch.isdigit():
                if len(stack) != 0 and isinstance(stack[-1], int):
                    stack.append(stack.pop() * 10 + int(ch))
                else:
                    stack.append(int(ch))
            elif ch != ']':
                stack.append(ch)
            else:
                string = []
                while True:
                    top = stack.pop()
                    if top == '[':
                        break
                    string.append(top)
                string.reverse()
                times = stack.pop()
                stack.append(''.join(string * times))
        return ''.join(stack)


if __name__ == '__main__':
    s = Solution()
    print s.decodeString('3[a]2[bc]')
    print s.decodeString('3[a2[c]]')
    print s.decodeString('2[abc]3[cd]ef')
