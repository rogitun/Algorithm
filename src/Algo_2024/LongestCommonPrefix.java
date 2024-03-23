package Algo_2024;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String s = longestCP(new String[]{"flower", "flow", "flight"});
    System.out.println(s);
  }

  public static String longestCP(String[] strs) {
    StringBuilder prefix = new StringBuilder(strs[0]);

    // prefix 선정 - 첫번째 문자열
    // 해당 문자열을 바탕으로 그 다음 문자열과 비교를 함.
    // 공통 prefix를 찾는 것이기 때문에 기준 문자열(prefix 변수)을 바탕으로 크기를 줄여나가며 prefix를 갱신함.
    // prefix가 최대한으로 작아지면(empty) return "", 그게 아니면 prefix가 정답.

    for (int i = 1; i < strs.length; i++) {
      // 기준 prefix 제외하고 다음부터 비교
      //prefix와 다음 문자열 비교하면서 크기 줄임.
      while (strs[i].indexOf(prefix.toString()) != 0) {
        prefix.deleteCharAt(prefix.length() - 1);
        if (prefix.length() == 0) {
          return "";
        }
      }
    }
    return prefix.toString();
  }
}
