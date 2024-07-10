package Algo_2024;

// number 1071.
public class GreatestCommonDivisorofStrings {

  public static void main(String[] args) {
    String s = gcdOfStrings("ABCABCABC", "ABCAAA");
    String s3 = gcdOfStrings("AAAAAA", "AAA");
    String s1 = gcdOfStrings("ABABAB", "ABAB");
    String s2 = gcdOfStrings("LEET", "CODE");
  }


  public static String gcdOfStrings(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }

    int gcdLength = gcd(str1.length(), str2.length());
    return str1.substring(0, gcdLength);
  }

  private static int gcd(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
}
