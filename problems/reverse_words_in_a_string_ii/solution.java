class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int start = 0;
        int end = 0;
        while (start < s.length) {
            while (end < s.length && s[end] != ' ') {
                end++;
            }

            reverse(s, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    public void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
