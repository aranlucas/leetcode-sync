class Solution {
    public String rearrangeString(String s, int k) {
        if (s.length() == 0 || k <= 0) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));

        Queue<Character> q = new ArrayDeque<>();

        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Character c = pq.poll();

            sb.append(c);
            q.add(c);
            map.put(c, map.get(c) - 1);

            if (q.size() >= k) {
                Character ch = q.poll();
                if (map.get(ch) > 0) {
                    pq.add(ch);
                }
            }
        }

        System.out.println(q);
        return sb.toString().length() == s.length() ? sb.toString() : "";
    }
}
