import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Create valid intervals
        for (int ch = 0; ch < 26; ch++) {

            if (first[ch] == n)
                continue;

            int left = first[ch];
            int right = last[ch];

            boolean valid = true;

            for (int i = left; i <= right; i++) {

                int current = s.charAt(i) - 'a';

                // Character occurs before left
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                // Expand right boundary
                right = Math.max(right, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort intervals according to ending position
        intervals.sort((a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];

            return a[0] - b[0];
        });

        List<String> answer = new ArrayList<>();

        int previousEnd = -1;

        // Greedy selection
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > previousEnd) {
                answer.add(s.substring(left, right + 1));
                previousEnd = right;
            }
        }

        return answer;
    }
}