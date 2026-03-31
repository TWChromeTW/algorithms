package tink.first_contest;

import java.util.Objects;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low, high, mid;
        low = 1;
        high = sc.nextInt();

        while (low < high) {
            mid = (low + high + 1) / 2;

            System.out.println(mid);
            System.out.flush();

            String str = sc.next();

            if (Objects.equals(str, "<")) {
                high = mid - 1;
            }
            else if (Objects.equals(str, ">=")) {
                low = mid;
            }
        }

        System.out.println("! " + low);
        System.out.flush();

    }

}
