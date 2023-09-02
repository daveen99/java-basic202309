package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz01 {
    public static void main(String[] args) {
        String[] foods = new String[0];
        System.out.println("# 먹고싶은 음식을 입력하세요!!");
        System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(">> ");
            String food = sc.nextLine();


            if (food.equals("그만")) break;
            else {
                String[] temp = new String[foods.length + 1];
                if (foods.length > 0) {
                    for (int i = 0; i < foods.length; i++) {
                        temp[i] = foods[i];
                    }
                }

                int tempLn = temp.length - 1;
                temp[tempLn] = food;
                foods = temp;
                temp = null;
            }


        }
        System.out.println("먹고 싶은 음식리스트: " + Arrays.toString(foods));

    }
}
