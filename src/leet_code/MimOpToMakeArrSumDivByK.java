//task number from leetcode 3512

package leet_code;

import java.util.Arrays;

public class MimOpToMakeArrSumDivByK {
    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        if (sum < k) {
            return sum;
        }
        else if (sum % k == 0) {
            return 0;
        }
        else {
            return sum % k;
        }
    }
}
