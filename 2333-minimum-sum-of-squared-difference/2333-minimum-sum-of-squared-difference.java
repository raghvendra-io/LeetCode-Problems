class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long low = 0, high = maxDiff;

        while (low < high) {
            long mid = (low + high) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = (int) low;
        long remaining = k;
        long result = 0;

        for (int d : diff) {
            if (d > limit) {
                remaining -= d - limit;
                d = limit;
            }
            result += (long) d * d;
        }
        PriorityQueue<Integer> heap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int d : diff) {
            heap.offer(Math.min(d, limit));
        }

        while (remaining > 0 && !heap.isEmpty()) {
            int d = heap.poll();
            if (d == 0) break;
            heap.offer(d - 1);
            remaining--;
        }

        result = 0;
        while (!heap.isEmpty()) {
            long d = heap.poll();
            result += d * d;
        }

        return result;
    }
}
