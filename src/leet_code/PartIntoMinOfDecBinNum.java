//task number from leetcode 1689

package leet_code;

public class PartIntoMinOfDecBinNum {

    public int minPartitions(String n) {
        return n.chars()
                .map(c -> c - '0')
                .max()
                .getAsInt();
    }

}
