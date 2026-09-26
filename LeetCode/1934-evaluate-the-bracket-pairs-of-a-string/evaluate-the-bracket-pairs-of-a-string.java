import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        // Store key-value pairs in HashMap
        HashMap<String, String> map = new HashMap<>();
        
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(') {
                // Find closing bracket
                int j = i + 1;
                
                while (s.charAt(j) != ')') {
                    j++;
                }
                
                // Extract key
                String key = s.substring(i + 1, j);
                
                // Replace with value, or '?' if not found
                if (map.containsKey(key)) {
                    ans.append(map.get(key));
                } else {
                    ans.append("?");
                }
                
                // Move i to closing bracket
                i = j;
            } 
            else {
                ans.append(s.charAt(i));
            }
        }
        
        return ans.toString();
    }
}