class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorterdArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(sorterdArray);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : sorterdArray) {
            rank.putIfAbsent(x, rank.size() + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }
}
