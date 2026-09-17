class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000;

        int[] best = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            best[i] = INF;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int sum = 0;
        int ans = INF;

        for (int i = 1; i <= n; i++) {
            sum += arr[i - 1];

            // Carry previous best
            best[i] = best[i - 1];

            if (map.containsKey(sum - target)) {
                int prev = map.get(sum - target);
                int len = i - prev;

                // Previous subarray must finish before prev
                if (best[prev] != INF) {
                    ans = Math.min(ans, len + best[prev]);
                }

                best[i] = Math.min(best[i], len);
            }

            map.put(sum, i);
        }

        return ans == INF ? -1 : ans;
    }
}