class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int x: nums) xor ^=x;
        int lowbit=xor & -xor;

        int a=0,b=0;
        for(int x:nums){
            if((x & lowbit) != 0) a^=x;
            else b ^=x;
        }
        return new int[] {a,b};
        
    }
}