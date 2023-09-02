package day01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] members = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};
        System.out.println("* 우리반 학생들의 별명: " + Arrays.toString(members));

        while (true) {
            System.out.println("ㅡ 삭제할 학생의 별명을 입력하세요!");
            System.out.print("> ");
            String delName = sc.nextLine();

            for (int i = 0; i < members.length; i++) {
                if (members[i].equals(delName)) {
                    System.out.println(delName + "의 별명을 삭제합니다.");
                    for (int j = i; j < members.length-1; j++) {
                        members[j] = members[j+1];
                    }
                    String[] temp = new String[members.length-1];
                    for (int j = 0; j < temp.length; j++) {
                        temp[j] = members[j];
                    }
                    members = temp;
                    temp = null;
                    System.out.println("* 삭제 후 정보: " + Arrays.toString(members));
                    break;
                } else if(i == members.length-1) {
                    System.out.println("해당 별명(" + delName + ")은(는) 존재하지 않습니다.");
                    break;
                }
            }
        }
    }
}
