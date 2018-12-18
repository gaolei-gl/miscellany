package com.lei.leetcode.P17;

import java.util.*;

public class Solution2 {
    final private Map<Character, String> map = new HashMap<>(9);

    public Solution2() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new LinkedList<>();
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, digits);
        return res;
    }

    private void backtrack(List<String> combinations, String pre, int idx, String digits) {
        if (idx == digits.length()) {
            combinations.add(pre);
            return;
        }
        String s = map.get(digits.charAt(idx));
        for (char c : s.toCharArray()) {
            pre = pre + c;
            backtrack(combinations, pre, idx + 1, digits);
            pre = pre.substring(0, pre.length() - 1);
        }

    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<String> res = s.letterCombinations("269");
        Collections.sort(res);
        System.out.println(res.size());
        for (String ss : res) {
            System.out.println(ss);
        }
//        ["adm","adn","ado","aem","aen","aeo","afm","afn","afo","bdm","bdn","bdo","bem","ben","beo","bfm","bfn","bfo","cdm","cdn","cdo","cem","cen","ceo","cfm","cfn","cfo"]
    }
}
