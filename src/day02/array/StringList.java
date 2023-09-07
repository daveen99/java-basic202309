package day02.array;

import java.util.Arrays;

public class StringList {

    // 스트링 배열을 필드로 등록
    String[] sArr;

    // 생성자를 통해 배열을 초기화
    StringList() {
        sArr = new String[0];
    }
    StringList(String... initData) {
        sArr = new String[initData.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = initData[i];
        }
    }

    // 배열 맨 끝데이터 제거
    void pop() {
        String[] temp = new String[sArr.length-1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = sArr[i];
        }
        sArr = temp;
    }

    void push(String push) {
        String[] temp = new String[sArr.length+1];
        for (int i = 0; i < sArr.length; i++) {
            temp[i] = sArr[i];
        }
        temp[temp.length-1] = push;
        sArr = temp;
    }

    void insert(int index, String insert) {
        String[] temp = new String[sArr.length+1];
        for (int i = 0; i < sArr.length; i++) {
            temp[i] = sArr[i];
        }

        for (int i = temp.length-1; i > index; i--) {
            temp[i] = temp[i-1];
        }
        temp[index] = insert;
        sArr=temp;
    }

    void remove(String target) {
        String[] temp = new String[sArr.length-1];
        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals(target)) {
                for (int j = i; j < sArr.length-1; j++) {
                    sArr[j] = sArr[j+1];
                }
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = sArr[j];
                }
                sArr = temp;
                return;
            }
        }
    }
    void remove(int target) {
        String[] temp = new String[sArr.length-1];

        for (int j = target; j < sArr.length-1; j++) {
            sArr[j] = sArr[j+1];
        }
        for (int j = 0; j < temp.length; j++) {
            temp[j] = sArr[j];
        }
        sArr = temp;
    }

    boolean includes(String target) {
        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    int indexOf(String target) {
        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    void clear() {
        sArr = new String[0];
    }

    boolean isEmpty() {
        if(sArr.length == 0)  return true;
        return false;
    }

    int size() {
        return sArr.length;
    }

    void printArray() {
        System.out.println(Arrays.toString(sArr));
    }
}
