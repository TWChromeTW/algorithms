package another;

public class Palindrom {

    private static boolean isPalindromFirst(String str) {
        if (str == null) return false;
        String cleanStr = str.replace("\\s+", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversedStr);
    }

    private static boolean isPalindromSecond(String str) {
        if (str == null) return false;
        String s = str.replace("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
