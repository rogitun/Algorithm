package Algo_2024.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    /*
    There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
    and an integer extraCandies, denoting the number of extra candies that you have.

    Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
    they will have the greatest number of candies among all the kids, or false otherwise.
    Note that multiple kids can have the greatest number of candies.
     */

    public static void main(String[] args) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        //1. 가장 큰 number find
        int big = 0;
        for (int num : candies) if (num >= big) big = num;
        //2. candies iter 돌면서 extra 더하고 가장 큰 number랑 >=인지 비교
        for (int candy : candies) {
            //3. 결과 배열에 저장.
            if (candy + extraCandies >= big) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
