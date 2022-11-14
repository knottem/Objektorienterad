import java.util.Arrays;

class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int test = 0;
            for (String operation : operations) {
                if (operation.equals("++X") || operation.equals("X++")) {
                    test++;
                } else if (operation.equals("--X") || operation.equals("X--")) {
                    test--;
                }
            }
            return test;
        }

    public static void main(String[] args) {
        Solution a = new Solution();
        String[] operations = {"--X","X++","X++"};
        System.out.println(a.finalValueAfterOperations(operations));

    }

}