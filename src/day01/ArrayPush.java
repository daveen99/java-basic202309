package day01;

import java.util.Arrays;

public class ArrayPush {
    public static void main(String[] args) {

        // push : 맨 끝에 데이터를 추가
        int[] arr = {10,20,30};
        int newData = 40;

        // 1. 기존 사이즈보다 1개 더 큰 새 배열을 생성
        int[] temp = new int[arr.length + 1];

        // 2. 기존 데이터를 전부 복사
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // 3. 맨 마지막 인덱스에 새 데이터를 추가
        temp[temp.length - 1] = newData;

        // 4. 주소값 변경
        arr = temp;
        temp = null;

        System.out.println("arr: = " + Arrays.toString(arr));
        System.out.println("temp: = " + Arrays.toString(temp));
    }
}
