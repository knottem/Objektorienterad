import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]) {
                nums[result]=nums[i+1];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] test = {0,0,1,1,1,2,2,3,3,4};
        int[] expected = {0,1,2,3,4};
        System.out.println(Arrays.toString(expected));
        int k = removeDuplicates(test);
        assert k == expected.length;
        System.out.println(k);
    }

}