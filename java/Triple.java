
/*
 *@program:java_study
 *@author: nbc/stone
 *@Time: 2022/5/24  16:48
 *@description: 三角形
 */

import java.util.Scanner;

public class Triple {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;

        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            if ((a < 1 || a > 200) || (b < 1 || b > 200) || (c < 1 || c > 200)) {
                System.out.println("输入有误");
                continue;
            }
            if (a + c <= b || c + b <= a || a + b <= c) {
                System.out.println("非三角形");
                continue;
            }
            checkshape(a, b, c);
        }

    }

    public static void checkshape(int a, int b, int c) {
        if ((a == b && a != c) || (a == c && a != b) || (c == b && a != c))
            System.out.println("等腰三角形");
        else if (a == b && b == c)
            System.out.println("等边三角形");
        else {
            System.out.println("不是等边三角形");
        }
    }
}


//        if (a < 1 || a > 200) {
//        System.out.println("a 必须在1到200之间");
//        continue;
//        }
//        if (b < 1 || b > 200) {
//        System.out.println("b 必须在1到200之间");
//        continue;
//        }
//        if (c < 1 || c > 200) {
//        System.out.println("c 必须在1到200之间");
//        continue;
//        }
//            if (a + c <= b) {
////                System.out.println("a + c must > b");
//                System.out.println("非三角形");
//                continue;
//            }
//
//            if (c + b <= a) {
////                System.out.println("c + b must > a");
//                System.out.println("非三角形");
//                continue;
//            }
//
//            if (a + b <= c) {
////                System.out.println("a + b must > c");
//                System.out.println("非三角形");
//                continue;
//            }
//            break;
//        }