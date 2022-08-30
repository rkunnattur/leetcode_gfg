class Solution {
    public int trap(int[] height) {
        int n = height.length, capacity = 0;
        int leftMax = height[0], rightMax = height[n-1];
        int l = 1, r = n-2;
        
        while(l <= r) {
            int minH = Math.min(leftMax, rightMax);
            if(leftMax <= rightMax) {
                if(height[l] < minH) capacity += minH - height[l];
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                if(height[r] < minH) capacity += minH - height[r];
                rightMax = Math.max(rightMax, height[r]);
                r--;
            } 
        }
        
        return capacity;
    }
}


/*
0,1,0,2,1,0,1,3,2,1,2,1
      l             r
  
if(height[l] < minH) capacity += minH - height[l]
left++


leftMax = 0
rightMax = 1
leftMax max()
minH = min(leftMax, rightMax) = 0 1 
*/