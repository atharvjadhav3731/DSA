import java.util.*;

class Solution {

    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parseExpression(expression);

        List<String> ans = new ArrayList<>(result);

        // Lexicographical order
        Collections.sort(ans);

        return ans;
    }

    // Handles UNION separated by comma
    private Set<String> parseExpression(String s) {
        Set<String> result = new HashSet<>();

        // First term
        result.addAll(parseTerm(s));

        // More terms separated by comma
        while (index < s.length() && s.charAt(index) == ',') {
            index++; // skip ','

            result.addAll(parseTerm(s));
        }

        return result;
    }

    // Handles CONCATENATION
    private Set<String> parseTerm(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> current = parseFactor(s);

            Set<String> temp = new HashSet<>();

            // Cartesian product
            for (String a : result) {
                for (String b : current) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }

    // Handles a single character or {...}
    private Set<String> parseFactor(String s) {

        Set<String> result;

        if (s.charAt(index) == '{') {

            index++; // skip '{'

            result = parseExpression(s);

            index++; // skip '}'

        } else {

            result = new HashSet<>();

            result.add(String.valueOf(s.charAt(index)));

            index++;
        }

        return result;
    }
}
