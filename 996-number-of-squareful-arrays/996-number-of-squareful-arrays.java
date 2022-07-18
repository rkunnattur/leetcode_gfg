class Solution {
    int count = 0;
    public int numSquarefulPerms(int[] nums) {
        int len = nums.length;
        
        if(len<2) return count;
        
        computeNoOfSquarefulPerms(nums, len, 0);
        return count;
    }
    
    public void computeNoOfSquarefulPerms(int[] nums, int len, int index){
        if(index==len) count++;
        
        Set<Integer> visitedIdx = new HashSet<Integer>();
        for(int i = index; i < len; i++){
            if(!visitedIdx.contains(nums[i]) && (i==index || nums[i]!=nums[index])){
                swap(nums, i, index);
                
                if(index==0 || isSquareFul(nums[index], nums[index-1]) )
                    computeNoOfSquarefulPerms(nums, len, index+1);
                
                //post recursion
                swap(nums, index, i);
                visitedIdx.add(nums[i]);
            }
        }
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public boolean isSquareFul(int a, int b){
        return ((Math.sqrt(a+b))%1==0)?true:false;
    }
}