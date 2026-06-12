class Solution {
    public int trap(int[] height) {
        // Edge case
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;

                // update leftMax
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }

                // water stored at this position
                waterTrapped += (leftMax - height[left]);

            } else {
                right--;

                // update rightMax
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }

                // water stored at this position
                waterTrapped += (rightMax - height[right]);
            }
        }

        return waterTrapped;
    }
}