class Solution {
    public int[] closestDivisors(int num) {

        int[] pair1 = findPair(num + 1);
        int[] pair2 = findPair(num + 2);

        int diff1 = Math.abs(pair1[0] - pair1[1]);
        int diff2 = Math.abs(pair2[0] - pair2[1]);

        if(diff1 < diff2) {
            return pair1;

        }

        return pair2;
    }

    private int[] findPair(int n) {
        int i = (int) Math.sqrt(n);

        while(i >= 1) {
            if(n % i == 0){
                return new int[] {i, n/i};

            }

            i--;
        }

        return new int[] {1, n};
        
    }
}