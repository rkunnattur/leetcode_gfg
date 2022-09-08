class Solution {
    
    int num = 0;
    
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        computeGrayCode(res, n);
        return res;
    }
    
    public void computeGrayCode(List<Integer> res, int n){
        if(n==0) {
            res.add(num);
            return;
        }
        
        computeGrayCode(res, n-1);
        num = num^(1<<(n-1));
        computeGrayCode(res, n-1);
    }
}