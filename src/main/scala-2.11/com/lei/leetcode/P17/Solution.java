package com.lei.leetcode.P17;

import java.util.*;

public class Solution {
    final private Map<Character, String> map = new HashMap<>(9);

    public Solution() {
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
        if(digits.isEmpty()) return new LinkedList<>();
        List<String> res = new ArrayList<>();
        res.add("");
        res = letterCombinationsHelper(res, digits);
        return res;
    }

    private List<String> letterCombinationsHelper(List<String> combinations, String digits) {
        if (digits.isEmpty()) return combinations;
        List<String> res = new LinkedList<>();
        String chars = map.get(digits.charAt(0));
        for (Character ch : chars.toCharArray())
            for (String combination : combinations) {
                res.add(combination + ch);
            }
        return letterCombinationsHelper(res, digits.substring(1));
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.letterCombinations("");
        Collections.sort(res);
        System.out.println(res.size());
        for (String ss : res) {
            System.out.println(ss);
        }
//        ["adm","adn","ado","aem","aen","aeo","afm","afn","afo","bdm","bdn","bdo","bem","ben","beo","bfm","bfn","bfo","cdm","cdn","cdo","cem","cen","ceo","cfm","cfn","cfo"]
    }
}
