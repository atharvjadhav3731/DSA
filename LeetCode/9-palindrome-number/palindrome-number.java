
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int iOriginal = x;
        int iReverse = 0;

        while (x != 0) {
            int iDigit = x % 10;
            iReverse = iReverse * 10 + iDigit;
            x = x / 10;
        }

        return iOriginal == iReverse;
    }
}
