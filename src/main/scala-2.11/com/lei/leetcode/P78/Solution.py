import copy


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        mem = set()
        resp = self.sub(nums, mem)
        return [list(ii) for ii in set(tuple(i) for i in resp)] + [[]]

    def sub(self, nums, mem):
        resp = []
        if tuple(nums) in mem:
            return resp
        if nums is None or len(nums) == 0:
            return resp
        resp.append(nums)
        for i in nums:
            it = copy.deepcopy(nums)
            it.remove(i)
            resp.extend(self.sub(it, mem))
        mem.add(tuple(nums))
        return resp


class Solution2(object):
    def subsets(self, nums):
        nums.sort()
        result = [[]]
        for num in nums:
            result += [i + [num] for i in result]
        return result


if __name__ == '__main__':
    s = Solution()
    print s.subsets([1, 2, 3, 4, 5, 6, 7, 8, 10, 0])
