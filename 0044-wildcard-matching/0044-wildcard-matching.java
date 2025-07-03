class Solution {
    int dp[][];

    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        dp = new int[l1 + 1][l2 + 1];
        for (int[] x : dp) Arrays.fill(x, -1);
        return solve(l1, l2, s, p) == 1;
    }
    int solve(int i, int j, String s, String p) {
        if (i <= 0 && j <= 0) return 1;
        if (i <= 0 && j > 0) {
            for (int x = 1; x <= j; x++) {
                if (p.charAt(x - 1) != '*') return dp[i][j] = 0;
            }
            return dp[i][j] = 1;
        }
        if (i > 0 && j <= 0) return dp[i][j] = 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = solve(i - 1, j - 1, s, p);
        }
        if (p.charAt(j - 1) == '*') {
            return dp[i][j] = (solve(i - 1, j, s, p) == 1 || solve(i, j - 1, s, p) == 1) ? 1 : 0;
        }
        return dp[i][j] = 0;
    }
}