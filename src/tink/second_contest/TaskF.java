package tink.second_contest;


import java.io.*;
import java.util.*;

public class TaskF {

    private class FenwickTree {
        private int[] tree;

        public FenwickTree() {
            tree = new int[(int)(1e6) + 1];
        }

        public void add(int i, int delta) {
            for (; i < tree.length; i += i & -i) {
                tree[i] += delta;
            }
        }

        public int sumPrefix(int i) {
            int sum = 0;
            for (; i > 0; i -= i & -i) {
                sum += tree[i];
            }

            return sum;
        }
    }

//    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StreamTokenizer st = new StreamTokenizer(br);
    private PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private Deque<Integer> queue = new ArrayDeque<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private FenwickTree tree = new FenwickTree();
    private int counter = 0;
    private List<Integer> list = new ArrayList<>();

    private void action(int i) throws IOException {
        switch (i) {
            case 1:
                counter++;
                st.nextToken();
                int id = (int) st.nval;
                queue.addLast(id);
                map.put(id, counter);
                tree.add(counter, +1);
                break;
            case 2:
                tree.add(map.get(queue.getFirst()), -1);
                queue.removeFirst();
                break;
            case 3:
                tree.add(map.get(queue.getLast()), -1);
                queue.removeLast();
                break;
            case 4:
                st.nextToken();
                int q = (int) st.nval;
                list.add(tree.sumPrefix(map.get(q) - 1));
                break;
            case 5:
                list.add(queue.getFirst());
                break;
        }
    }

    private void run() throws IOException {
        st.nextToken();
        int n = (int) st.nval;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int act =  (int) st.nval;
            action(act);
        }

        for (int i = 0; i < list.size(); i++) {
            pw.println(list.get(i));
        }
        pw.flush();
    }

    public static void main(String[] args) throws IOException {
        new TaskF().run();
    }

}
