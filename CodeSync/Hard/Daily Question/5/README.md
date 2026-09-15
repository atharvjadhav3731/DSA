# 5

- Platform: LeetCode
- Language: Daily Question
- Difficulty: Hard
- Topics: Two Pointers, String, Dynamic Programming, Greedy
- Runtime: N/A
- Memory: N/A
- Problem URL: https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/description/?envType=daily-question&envId=2026-09-15
- Synced: 2026-09-15T16:27:18.508Z

## Problem Description

You are given a string s and a positive integer k. Select a set of non-overlapping substrings from the string s that satisfy the following conditions: The length of each substring is at least k. Each substring is a palindrome. Return the maximum number of substrings in an optimal selection. A substring is a contiguous sequence of characters within a string. Example 1: Input: s = "abaccdbbd", k = 3 Output: 2 Explanation: We can select the substrings underlined in s = "abaccdbbd". Both "aba" and "dbbd" are palindromes and have a length of at least k = 3. It can be shown that we cannot find a selection with more than two valid substrings. Example 2: Input: s = "adbcda", k = 2 Output: 0 Explanation: There is no palindrome substring of length at least 2 in the string. Constraints: 1 <= k <= s.length <= 2000 s consists of lowercase English letters.

## Explanation

This solution was accepted on LeetCode using Daily Question. The detected topics are Two Pointers, String, Dynamic Programming, Greedy. Review the synced source file for the implementation details.
