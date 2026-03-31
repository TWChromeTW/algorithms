package recursion;

public class RecursionSum {

    public static int recursionSum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int sum = arr[0];

//        var new_len = arr.length - 1;
        int new_arr[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) new_arr[i - 1] = arr[i];

        return sum + recursionSum(new_arr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(recursionSum(arr));
    }

}
