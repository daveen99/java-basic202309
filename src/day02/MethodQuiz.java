package day02;

import java.util.Arrays;

public class MethodQuiz {

    static String[] foods = {"떡볶이", "치킨", "파스타"};
    static String[] userName = {"홍길동", "고길동"};

    static void printFoods() {
        System.out.println(Arrays.toString(foods));
    }

    static void push(String food) {
        String[] temp = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[foods.length] = food;

        foods = temp;
    }

    static int indexOf(String food) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                return i;
            }
        }
        return -1;
    }

    static void remove(String food) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                int index = i;
                String[] temp = new String[foods.length - 1];

                if (index == foods.length - 1) {
                    for (int z = 0; z < temp.length; z++) {
                        temp[z] = foods[z];
                    }
                } else {
                    for (int x = index; x < foods.length - 1; x++) {
                        foods[x] = foods[x + 1];
                    }

                    for (int z = 0; z < temp.length; z++) {
                        temp[z] = foods[z];
                    }
                }

                foods = temp;
                break;
            }
            if (i == foods.length-1) {
                System.out.println("존재하지 않는 음식입니다.");
            }
        }



    }

    static boolean include(String food) {
        for (int i = 0; i < foods.length; i++) {
            if (foods[i].equals(food)) {
                return true;
            }
        }
        return false;
    }

    static void insert(int index, String food) {
        String[] temp2 = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp2[i] = foods[i];
        }

        for (int x = index; x < temp2.length - 1; x++) {
            temp2[x + 1] = temp2[x];
        }

        temp2[index] = food;

        foods = temp2;
    }

    static void modify(int index, String food) {
        foods[index] = food;
    }

    static void clear() {
        String[] temp = new String[0];
        foods = temp;
        System.out.print("배열 초기화 진행결과: ");
        printFoods();
    }

    public static void main(String[] args) {
        printFoods();
        push("라면");
        push("김치찌개");
        printFoods();

        // idx에 2가 리턴되어야 함.
        int idx = indexOf("파스타");
        System.out.println("idx = " + idx);
        // idx에 4가 리턴되어야 함.
        int idx2 = indexOf("김치찌개");
        System.out.println("idx2 = " + idx2);
        // idx에 -1이 리턴되어야 함.
        int idx3 = indexOf("짜장면");
        System.out.println("idx3 = " + idx3);

        remove("김치찌개"); // foods배열에서 김치찌개 제거
        remove("망고"); // 존재하지 않는 음식명입니다 출력.

        printFoods();


        boolean flag = include("파스타"); // 파스타 발견시 true 리턴
        System.out.println("flag = " + flag);
        boolean flag2 = include("양념치킨"); // 양념치킨 미발견시 false 리턴
        System.out.println("flag2 = " + flag2);

        insert(3, "파인애플"); // 3번 인덱스에 파인애플 삽입
        modify(2, "닭갈비");  // 2번 인덱스 데이터 닭갈비로 수정

        printFoods();
        clear();  // foods배열 모든 데이터 삭제
    }
}
