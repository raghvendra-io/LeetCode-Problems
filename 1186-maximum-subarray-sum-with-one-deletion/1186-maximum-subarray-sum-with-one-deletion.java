class Solution {
    public int maximumSum(int[] arr) {
        
        int noDelete = arr[0];
        int oneDelete = arr[0];
        int globalMax = arr[0];
    
        for (int i = 1; i < arr.length; i++) {
            
            
            oneDelete = Math.max(noDelete, oneDelete + arr[i]);
            
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            
            globalMax = Math.max(globalMax, Math.max(noDelete, oneDelete));
        }
        
        return globalMax;
    }
}
