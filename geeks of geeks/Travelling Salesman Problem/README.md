# Travelling Salesman Problem

- Platform: GeeksforGeeks
- Language: {...} //Driver Code Starts #include <iostream> #include <vector> #include <algorithm> using namespace std; //Driver Code Ends int dfs(vector<vector<int>>& cost, vector<bool>& vis, int last, int cnt) { int n = cost.size(); // If all visited -> return cost back to start (0) if (cnt == n) return cost[last][0]; int minCost = (int)1e9; for (int city = 1; city < n; city++) { if (!vis[city]) { // mark the city as visited and explore // all possible paths from there vis[city] = true; minCost = min(minCost, cost[last][city] + dfs(cost, vis, city, cnt + 1)); // backtrack vis[city] = false; } } // return min cost among all possible paths return minCost; } int tsp(vector<vector<int>>& cost) { int n = cost.size(); // to make sure that a city is visited exactly once vector<bool> vis(n, false); vis[0] = true; return dfs(cost, vis, 0, 1); } {...} //Driver Code Starts int main() { vector<vector<int>> cost = { {0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0} }; int res = tsp(cost); cout << res; } //Driver Code Ends
- Difficulty: Unknown
- Topics: Placement 360 Course Explore, Placement 360 Course, Explore
- Runtime: N/A
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/dsa/travelling-salesman-problem-using-dynamic-programming/
- Synced: 2026-11-03T05:16:25.487Z

## Problem Description

Problem description was not available on the page at sync time.

## Explanation

This solution was accepted on GeeksforGeeks using {...} //Driver Code Starts #include <iostream> #include <vector> #include <algorithm> using namespace std; //Driver Code Ends int dfs(vector<vector<int>>& cost, vector<bool>& vis, int last, int cnt) { int n = cost.size(); // If all visited -> return cost back to start (0) if (cnt == n) return cost[last][0]; int minCost = (int)1e9; for (int city = 1; city < n; city++) { if (!vis[city]) { // mark the city as visited and explore // all possible paths from there vis[city] = true; minCost = min(minCost, cost[last][city] + dfs(cost, vis, city, cnt + 1)); // backtrack vis[city] = false; } } // return min cost among all possible paths return minCost; } int tsp(vector<vector<int>>& cost) { int n = cost.size(); // to make sure that a city is visited exactly once vector<bool> vis(n, false); vis[0] = true; return dfs(cost, vis, 0, 1); } {...} //Driver Code Starts int main() { vector<vector<int>> cost = { {0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0} }; int res = tsp(cost); cout << res; } //Driver Code Ends. The detected topics are Placement 360 Course Explore, Placement 360 Course, Explore. Review the synced source file for the implementation details.
