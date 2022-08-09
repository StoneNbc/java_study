
/*
 *@program:java_study
 *@author: nbc/stone
 *@Time: 2022/5/24  17:12
 *@description: 计算明天
 */

import java.util.Scanner;

class NextData {

    static int mouth = 0;
    static int day = 0;
    static int year = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("------------------------");
            check_input();
            NextDate();
            System.out.printf("next date is:%d %d %d \n", year, mouth, day);
            iniData();
            System.out.println("------------------------");
        }

    }

    static void iniData() {
        mouth = 0;
        year = 0;
        day = 0;
    }

    static void NextDate() {

        if (mouth == 2) {
            //闰年
            if (day == 29 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                mouth = 3;
                day = 1;
            } else if (day == 28 && !((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                mouth = 3;
                day = 1;
            } else {
                day++;
            }
        } else if (mouth == 4 || mouth == 6 || mouth == 9 || mouth == 11) {
            if (day == 30) {
                mouth++;
                day = 1;
            } else day++;
        } else if (mouth == 12 && day == 31) {
            mouth = 1;
            day = 1;
            year++;
        } else if (mouth == 1 || mouth == 3 || mouth == 5 || mouth == 7 || mouth == 8 || mouth == 10) {
            if (day == 31) {
                mouth++;
                day = 1;
            } else day++;
        } else {
            day++;
        }
    }

    static void check_input() {

        System.out.print("please input year:");
        year = scanner.nextInt();
        while (year < 1812 || year > 2012) {
            System.out.print("year必须是1812到2012之间，请重新输入年份:");
            year = scanner.nextInt();
        }

        System.out.print("please input mouth:");
        mouth = scanner.nextInt();
        while (mouth > 12 || mouth < 1) {
            System.out.print("月份必须是1到12月之间请重新输入月份:");
            mouth = scanner.nextInt();
        }

        System.out.print("please input day:");
        day = scanner.nextInt();

        while (day < 1 || day > 31) {
            System.out.print("day必须是1到31之间，请重新输入日期:");
            day = scanner.nextInt();
        }

        while ((mouth == 4 || mouth == 6 || mouth == 9 || mouth == 11) && day > 30) {
            System.out.print("小月不能有31天,请重新输入:");
            day = scanner.nextInt();
        }

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            while (mouth == 2 && day > 29) {
                System.out.print("闰年2月不能有超过29天,请重新输入:");
                day = scanner.nextInt();
            }
        } else {
            while (mouth == 2 && day > 28) {
                System.out.print("非闰年2月不能有超过28天,请重新输入:");
                day = scanner.nextInt();
            }
        }

        System.out.printf("输入为:%d %d %d\n", year, mouth, day);
    }
}

//        while (day > 28) {
//            if (!((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
//                System.out.print("day必须是1到28之间，请重新输入日期:");
//                day = scanner.nextInt();
//                continue;
//            } else {
//                break;
//            }
//        }