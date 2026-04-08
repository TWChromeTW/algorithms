package yandex;

import java.io.*;
import java.util.*;

public class TaskD {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        long nextLong() { return Long.parseLong(next()); }
    }

    private static void printRes(long[] nums, long m1, long m2) {
        if (m1 == 0 || m2 == 0) return; // На всякий случай
        printMask(m1);
        printMask(m2);
    }

    private static void printMask(long mask) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if (((mask >> i) & 1) == 1) idx.add(i + 1);
        }
        System.out.println(idx.size());
        for (int i = 0; i < idx.size(); i++) {
            System.out.print(idx.get(i) + (i == idx.size() - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long[] nums = new long[40];
        for (int i = 0; i < 40; i++) nums[i] = fr.nextLong();

        int tableSize = 1 << 21;
        int maskBit = tableSize - 1;
        long[] keys = new long[tableSize];
        long[] values = new long[tableSize];
        boolean[] used = new boolean[tableSize];

        Random rnd = new Random();

        while (true) {
            long mask = Math.abs(rnd.nextLong()) % (1L << 40);
            if (mask == 0) continue;

            long currentSum = 0;
            for (int i = 0; i < 40; i++) {
                if (((mask >> i) & 1) == 1) currentSum += nums[i];
            }

            int h = (int)((currentSum ^ (currentSum >>> 32)) & maskBit);
            while (used[h]) {
                if (keys[h] == currentSum && values[h] != mask) {
                    // Нашли коллизию!
                    long m1 = values[h];
                    long m2 = mask;
                    long common = m1 & m2;
                    printRes(nums, m1 ^ common, m2 ^ common);
                    return;
                }
                h = (h + 1) & maskBit;
            }

            keys[h] = currentSum;
            values[h] = mask;
            used[h] = true;
        }
    }
}