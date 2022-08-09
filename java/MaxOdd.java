
/*
 *@program:java
 *@author: nbc/stone
 *@Time: 2022/6/15  20:23
 *@description: zlr傻逼
 */

public class MaxOdd {
    public static void main(String[] args) {
        int[] array = new int[]{-3, 6, 9, 10, 15, 0, 8, -7};
        int max = MaxOdd(array);
        System.out.println(max);
    }

    public static int MaxOdd(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
