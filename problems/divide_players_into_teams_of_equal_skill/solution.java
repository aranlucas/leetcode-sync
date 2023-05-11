class Solution {
  public long dividePlayers(int[] skill) {
    int totalSkill = 0;
    int n = skill.length;
    for (int i = 0; i < skill.length; i++) {
      totalSkill += skill[i];
    }

    int groups = skill.length / 2;
    int targetSkill = totalSkill / groups;
    ArrayList<int[]> result = new ArrayList();

    System.out.println(targetSkill);
    Arrays.sort(skill);

    for (int i = 0; i < skill.length / 2; i++) {
      if (skill[i] + skill[n - i - 1] != skill[0] + skill[n - 1]) {
        return -1;
      }
      result.add(new int[] {skill[i], skill[n - i - 1]});
    }

    System.out.println(Arrays.deepToString(result.toArray()));
    long chemistry = 0;
    for (int i = 0; i < result.size(); i++) {
      int[] pair = result.get(i);

      int mult = pair[0] * pair[1];

      chemistry += mult;
    }

    return chemistry;
  }
}
