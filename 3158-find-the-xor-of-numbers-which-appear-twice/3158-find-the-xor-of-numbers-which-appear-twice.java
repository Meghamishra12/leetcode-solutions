class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        long seen=0;
        int xor=0;
        for(int x:nums){
            if((seen&(1L << x)) !=0) xor^=x;
            else seen |=1L <<x;
        }
        return xor;
        
    }
}