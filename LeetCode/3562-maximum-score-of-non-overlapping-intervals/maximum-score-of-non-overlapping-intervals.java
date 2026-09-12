import java.util.*;

class Solution {

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // start, end, weight, original index
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0])
                return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        // Find next non-overlapping interval
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int low = i + 1;
            int high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                // Intervals are inclusive, so start must be > end
                if (a[mid][0] > a[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = low;
        }

        /*
         * dp[i][k] =
         * best result starting from i
         * using at most k intervals
         */
        Result[][] dp = new Result[n + 1][5];

        // IMPORTANT: initialize k = 0 for every i
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new Result(0, new ArrayList<>());
        }

        // At the end, selecting nothing gives score 0
        for (int k = 1; k <= 4; k++) {
            dp[n][k] = new Result(0, new ArrayList<>());
        }

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't select current interval
                Result skip = dp[i + 1][k];

                // Option 2: Select current interval
                Result nextResult = dp[next[i]][k - 1];

                List<Integer> selected = new ArrayList<>(
                        nextResult.indices
                );

                selected.add(a[i][3]);

                // Keep indices sorted for lexicographical comparison
                Collections.sort(selected);

                Result take = new Result(
                        a[i][2] + nextResult.score,
                        selected
                );

                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> answer = dp[0][4].indices;

        Collections.sort(answer);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Return the better result
    static Result better(Result a, Result b) {

        // Higher score is better
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller indices
        int size = Math.min(
                a.indices.size(),
                b.indices.size()
        );

        for (int i = 0; i < size; i++) {

            if (!a.indices.get(i).equals(b.indices.get(i))) {

                return a.indices.get(i) < b.indices.get(i)
                        ? a
                        : b;
            }
        }

        return a.indices.size() <= b.indices.size() ? a : b;
    }
}