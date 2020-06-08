import java.util.Scanner;

public class Fourth {

    static int characterCount(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c++;
        }
        return c;
    }

    public static String swap(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    static void permutations(String s, int start, int end) {
        if (start == end - 1)
            System.out.println(s);
        else {
            for (int i = start; i < end; i++) {
                s = swap(s, start, i);
                permutations(s, start + 1, end);
                s = swap(s, start, i);
            }
        }

    }

    static void frequency(String s) {
        int freqArr[] = new int[26];
        char[] strArr = s.toCharArray();
        for (char ch : strArr) {
            if(ch != ' '){
            int i = (int)ch - 65;
            freqArr[i] += 1;
            }
        }
        for(int i = 0; i < freqArr.length; i++) {
            if(freqArr[i] > 0){
                System.out.println("Frequency of " + (char)(i+65) + " : " + freqArr[i]);
            }
        }
    }

    static boolean palindrome(String s) {
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reverse = reverse + s.charAt(i);
        }
        return s.equals(reverse);
    }

    public static void main(String[] args) {
        System.out.println("Enter a String.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = characterCount(str);
        System.out.println();
        System.out.println("There are total " + len + " characters in the string \"" + str + "\"");
        System.out.println();
        System.out.println("All possible permutations for the string \"" + str + "\" are:");
        permutations(str, 0, len);
        System.out.println();
        System.out.println("Frequency of characters is:");
        frequency(str.toUpperCase());
        System.out.println();
        boolean isPalindrome = palindrome(str);
        System.out.println(isPalindrome?"Yes, it's a palindrome":"No, it's not a palindrome");
        sc.close();
    }
}