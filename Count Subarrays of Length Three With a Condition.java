class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0; // Initialize the count of valid subarrays

        // Traverse the array, ensuring we only consider subarrays of length 3
        for (int i = 0; i <= nums.length - 3; i++) {
            // Extract elements of the current subarray
            int first = nums[i];
            int middle = nums[i + 1];
            int third = nums[i + 2];

            // Check the condition: sum of first and third == half of the middle
            if (first + third == middle / 2.0) {
                count++; // Increment the count if condition is satisfied
            }
        }

        return count; // Return the total count of valid subarrays
    }
}
