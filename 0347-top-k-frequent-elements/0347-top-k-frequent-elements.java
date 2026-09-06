class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {
            int frequency = map.get(num);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int frequency = bucket.length - 1;
             frequency >= 0;
             frequency--) {

            if (bucket[frequency] == null) {
                continue;
            }

            for (int num : bucket[frequency]) {
                result[index] = num;
                index++;

                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}