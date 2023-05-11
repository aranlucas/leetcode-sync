class UnionFind {
  int[] parents;

  public UnionFind() {
    parents = new int[26];

    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }
  }

  public int find(int ele) {
    if (ele == parents[ele]) {
      return ele;
    }

    return parents[ele] = find(parents[ele]);
  }

  public void union(int p, int q) {
    int parentP = find(p);
    int parentQ = find(q);

    if (parentP == parentQ) {
      return;
    }

    if (parentP > parentQ) {
      parents[parentP] = parentQ;
    } else if (parentP < parentQ) {
      parents[parentQ] = parentP;
    }
  }
}

class Solution {
  public String smallestEquivalentString(String s1, String s2, String baseStr) {
    UnionFind uf = new UnionFind();
    int n = s1.length();

    for (int i = 0; i < n; i++) {
      uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < baseStr.length(); i++) {
      char ch = (char) (uf.find(baseStr.charAt(i) - 'a') + 'a');
      sb.append(ch);
    }

    return sb.toString();
  }
}
