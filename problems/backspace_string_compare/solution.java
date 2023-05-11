class Solution {
  public boolean backspaceCompare(String s, String t) {
    if (s.equals(t)) {
      return true;
    }

    Deque<Character> sStack = new ArrayDeque<>();
    Deque<Character> tStack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c != '#') {
        sStack.addLast(c);
      } else if (!sStack.isEmpty()) {
        sStack.removeLast();
      }
    }

    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);

      if (c != '#') {
        tStack.addLast(c);
      } else if (!tStack.isEmpty()) {
        tStack.removeLast();
      }
    }

    return String.valueOf(tStack).equals(String.valueOf(sStack));
  }
}
