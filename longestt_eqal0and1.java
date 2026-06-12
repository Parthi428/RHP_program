class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int maxLen = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            int zeros = 0;
            int ones = 0;

            // count consecutive 0s
            while (i < n && s.charAt(i) == '0') {
                zeros++;
                i++;
            }

            // count consecutive 1s
            while (i < n && s.charAt(i) == '1') {
                ones++;
                i++;
            }

            // calculate balanced length
            int currentLen = 2 * Math.min(zeros, ones);
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }

        return maxLen;
    }
}