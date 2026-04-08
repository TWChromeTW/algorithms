package yandex;

import java.io.*;
import java.util.*;

public class TaskB {
    static class FastReader {
        InputStream is;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        public FastReader(InputStream is) { this.is = is; }

        public int read() {
            if (numChars == -1) return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try { numChars = is.read(buf); } catch (IOException e) { return -1; }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (c != -1 && (c < '0' || c > '9')) c = read();
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }

        public char nextCell() {
            int c = read();
            while (c != -1 && c != '0' && c != 'x') c = read();
            return (char) c;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int h = fr.nextInt();
        int w = fr.nextInt();
        if (h <= 0 || w <= 0) return;

        int[] grains = new int[w];
        int[] stoneCount = new int[w];

        int[] grainRows = new int[h * w];
        int[] grainStart = new int[w];
        int[] grainPtr = new int[w];

        int[] stoneRows = new int[h * w];
        int[] stoneStart = new int[w];

        byte[] grid = new byte[h * w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = fr.nextCell();
                grid[i * w + j] = (byte) c;
                if (c == '0') grains[j]++;
                if (c == 'x') stoneCount[j]++;
            }
        }

        int gIdx = 0, sIdx = 0;
        for (int j = 0; j < w; j++) {
            grainStart[j] = gIdx;
            stoneStart[j] = sIdx;
            for (int i = 0; i < h; i++) {
                if (grid[i * w + j] == '0') grainRows[gIdx++] = i;
                if (grid[i * w + j] == 'x') stoneRows[sIdx++] = i;
            }
        }
        grid = null;

        for (int j = 0; j < w; j++) {
            int count = stoneCount[j];
            for (int k = 0; k < count; k++) {
                if (j + 1 < w && grains[j + 1] > 0) {
                    int topRowRight = grainRows[grainStart[j + 1] + grainPtr[j + 1]];
                    int heightRight = h - topRowRight;
                    if (heightRight > grains[j] + 1) {
                        grains[j + 1]--;
                        grainPtr[j + 1]++;
                        grains[j]++;
                        continue;
                    }
                }

                if (j - 1 >= 0 && grains[j - 1] > grains[j] + 1) {
                    grains[j - 1]--;
                    grains[j]++;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                pw.print(i < h - grains[j] ? '-' : '0');
                if (j < w - 1) pw.print(' ');
            }
            pw.println();
        }
        pw.flush();
    }
}