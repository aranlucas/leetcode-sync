class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int activeFrogs = 0;
        int ans = -1;

        for (char ch : croakOfFrogs.toCharArray()) {
            switch (ch) {
                case 'c':
                    c++;
                    activeFrogs++;
                    break;
                case 'r':
                    r++;
                    if (c < r) {
                        return -1;
                    }
                    break;
                case 'o':
                    o++;
                    if (r < o) {
                        return -1;
                    }
                    break;
                case 'a':
                    a++;
                    if (o < a) {
                        return -1;
                    }
                    break;
                case 'k':
                    k++;
                    if (a < k) {
                        return -1;
                    }
                    activeFrogs--;
                    break;
            }
            ans = Math.max(ans, activeFrogs);
        }

        return activeFrogs == 0 ? ans : -1;
    }
}
