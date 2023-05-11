class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int charsInSection = 2 * (numRows - 1);

        for (int row = 0; row < numRows; row++) {
            int index = row;

            while (index < n) {
                answer.append(s.charAt(index));
                // Not first or last row
                if (row != 0 && row != numRows - 1) {
                    int charsInBetween = charsInSection - 2 * row;
                    int secondIndex = index + charsInBetween;
                    if (secondIndex < n) {
                        answer.append(s.charAt(secondIndex));
                    }
                }

                index += charsInSection;
            }
        }

        return answer.toString();
    }
}
