/*
 * Platform: LeetCode
 * Problem: 2
 * URL: https://leetcode.com/submissions/detail/2144864024/
 * Language: Java
 * Difficulty: Hard
 * Topics: Uncategorized
 * Runtime: 79 ms
 * Memory: 134.85 MB
 * Synced: 2026-10-02T18:26:49.488Z
 */

1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int INF = 1000000;
5
6        int[] best = new int[n + 1];
7
8        for (int i = 0; i <= n; i++) {
9            best[i] = INF;
10        }
11
12        HashMap<Integer, Integer> map = new HashMap<>();
13        map.put(0, 0);
14
15        int sum = 0;
16        int ans = INF;
17
18        for (int i = 1; i <= n; i++) {
19            sum += arr[i - 1];
20
21            // Carry previous best
22            best[i] = best[i - 1];
23
24            if (map.containsKey(sum - target)) {
25                int prev = map.get(sum - target);
26                int len = i - prev;
27
28                // Previous subarray must finish before prev
29                if (best[prev] != INF) {
30                    ans = Math.min(ans, len + best[prev]);
31                }
32
33                best[i] = Math.min(best[i], len);
34            }
35
36            map.put(sum, i);
37        }
38
39        return ans == INF ? -1 : ans;
40    }
41}
