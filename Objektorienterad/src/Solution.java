import java.util.Arrays;

class Solution {

    public void print(String string){
        System.out.println(string);
    }


    public static void main(String[] args) {
        Solution a = new Solution();
        String[] operations = {"--X","X++","X++"};
        a.print(Arrays.toString(operations));


    }

}