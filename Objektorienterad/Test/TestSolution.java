import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSolution {

    @Test
    void testFunction(){
        int[] test = {0,0,1,1,1,2,2,3,3,4};
        int[] expected = {0,1,2,3,4};
        System.out.println(Arrays.toString(expected));
        int k = Solution.removeDuplicates(test);
        assert k == expected.length;
    }
}
