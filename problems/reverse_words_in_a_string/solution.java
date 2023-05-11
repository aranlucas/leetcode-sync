class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        Deque<String> d = new ArrayDeque<>();

        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                word.append(c);
            } else if ((word.length() != 0) && (c == ' ')) {
                d.push(word.toString());
                word.setLength(0);
            }
            left++;
        }

        d.push(word.toString());

        return String.join(" ", d);
    }
}
