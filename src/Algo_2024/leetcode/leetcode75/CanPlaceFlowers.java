package Algo_2024.leetcode.leetcode75;

public class CanPlaceFlowers {

    /*
    You have a long flowerbed in which some of the plots are planted,
    and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
    and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
     */

    /*
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true
     */

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0, 1, 0}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlant = 0;
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 1) {
                continue;
            }
            else if ((i != flowerbed.length - 1) && flowerbed[i + 1] == 1)
                i++;
            else {
                canPlant++;
            }
        }
        return canPlant >= n;
    }
}
