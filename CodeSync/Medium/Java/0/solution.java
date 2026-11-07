/*
 * Platform: LeetCode
 * Problem: 0
 * URL: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/description/?envType=problem-list-v2&envId=string
 * Language: Java
 * Difficulty: Medium
 * Topics: String, Stack, Bracket Sequences
 * Runtime: N/A
 * Memory: N/A
 * Synced: 2026-11-07T17:07:06.988Z
 */

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {

            if (seq.charAt(i) == '(') {
                depth++;
                ans[i] = depth % 2;
            } else {
