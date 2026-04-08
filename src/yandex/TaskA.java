package yandex;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StreamTokenizer st = new StreamTokenizer(br);
    private static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    private static int[] start = new int[1000010];
    private static int[] obsLens;
    private static int[] obsPts;
    private static boolean[] isPassed;
    private static ArrayList<Integer> listCoorLets = new ArrayList<>();
    private static boolean invalidField = false;

    private static void fillingInTheField() throws IOException {
        st.nextToken();
        int countLets = (int) st.nval;

        obsLens = new int[countLets];
        obsPts = new int[countLets];
        isPassed = new boolean[countLets];

        for (int i = 0; i < countLets; i++) {
            st.nextToken();
            listCoorLets.add((int) st.nval);
        }

        int lastEnd = -1;
        for (int i = 0; i < countLets; i++) {
            int coor = listCoorLets.get(i);
            st.nextToken();
            int type = (int) st.nval;

            int len = (type == 1) ? 1 : (type == 2 ? 2 : 4);
            int pts = (type == 1) ? 1 : (type == 2 ? 3 : 5);


            if (coor <= lastEnd) {
                invalidField = true;
            }
            lastEnd = coor + len;

            if (coor < 1000001) {
                start[coor] = i + 1;
            }
            obsLens[i] = len;
            obsPts[i] = pts;
        }
    }

    private static void run() throws IOException {
        fillingInTheField();

        st.nextToken();
        int countJumps = (int) st.nval;
        int[] jumpCoors = new int[countJumps];
        for (int i = 0; i < countJumps; i++) {
            st.nextToken();
            jumpCoors[i] = (int) st.nval;
        }

        for (int i = 0; i < countJumps; i++) {
            st.nextToken();
            int jumpLen = (int) st.nval;
            int jumpStart = jumpCoors[i];
            int jumpEnd = jumpStart + jumpLen;

            if (invalidField) continue;


            for (int k = jumpStart; k < jumpEnd; k++) {
                if (k >= 1000001) break;
                if (start[k] > 0) {
                    int obsIdx = start[k] - 1;

                    if (k + obsLens[obsIdx] <= jumpEnd) {
                        isPassed[obsIdx] = true;
                    }
                }
            }
        }

        if (invalidField) {
            pw.println(0);
        } else {
            long totalScore = 0;
            for (int i = 0; i < obsLens.length; i++) {
                if (isPassed[i]) {
                    totalScore += obsPts[i];
                } else {
                    totalScore -= 1;
                }
            }
            pw.println(Math.max(0, totalScore));
        }
    }

    public static void main(String[] args) throws IOException {
        TaskA.run();
        pw.flush();
    }
}