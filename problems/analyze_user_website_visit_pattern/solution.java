import java.util.*;

record Pattern(int timestamp, String website) {};
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;

        Map<String, List<Pattern>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(username[i], k -> new ArrayList<>()).add(new Pattern(timestamp[i], website[i]));
        }

        Map<String, Integer> sequence = new HashMap<>();
        int maxCount = 0;
        String maxseq = "";
        for (var k: graph.entrySet()) {
            if (k.getValue().size() < 3) {
                continue;
            }
            List<Pattern> list = k.getValue();
            Collections.sort(list, (a, b) -> a.timestamp() - b.timestamp());
            Set<String> subseqences = subsequence(list);
            for (String seq : subseqences){
                sequence.put(seq, sequence.getOrDefault(seq, 0) + 1);
                if (sequence.get(seq) > maxCount){
                    maxCount = sequence.get(seq);
                    maxseq = seq;
                } 
                if (sequence.get(seq) == maxCount && seq.compareTo(maxseq) < 0) {
                    maxseq = seq;
                }

            }
        }
        String[] strs = maxseq.split(",");
        List<String> res = new ArrayList<>();
        for (String s : strs) {
            res.add(s);
        }        
        return res;    
    }
    
    public Set<String> subsequence(List<Pattern> list){
        int n = list.size();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < n-2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    res.add(list.get(i).website() + "," + list.get(j).website() + "," + list.get(k).website());
                }
            }
        }
        return res;
    }
}