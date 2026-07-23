class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currentMax = 0;
        int currentMin = 0;
        int maxAbsolute = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            // Peak Tracker: Build the highest positive mountain
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Valley Tracker: Dig the deepest negative valley
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            
            // Does our mountain OR our valley beat the absolute record?
            int peakAbs = Math.abs(currentMax);
            int valleyAbs = Math.abs(currentMin);
            
            maxAbsolute = Math.max(maxAbsolute, Math.max(peakAbs, valleyAbs));
        }
        
        return maxAbsolute;
    }
}