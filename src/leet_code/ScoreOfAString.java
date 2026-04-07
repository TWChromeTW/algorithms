//task number from leetcode 3110

package leet_code;

public class ScoreOfAString {

    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs((int)arr[i] - (int)arr[i+1]);
        }

        return sum;
    }

}
