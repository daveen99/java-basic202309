package day02.array;

import java.util.Arrays;

public class StringList {

    // 스트링 배열을 필드로 등록
    String[] sArr;

    // 생성자를 통해 배열을 초기화
    public StringList() {
        sArr = new String[0];
    }
    StringList(String... initData) {
        sArr = new String[initData.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = initData[i];
        }
    }
    public String[] getsArr() {
        return sArr;
    }
    // 배열 맨 끝데이터 제거
    void pop() {
        String[] temp = new String[sArr.length-1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = sArr[i];
        }
        sArr = temp;
    }

    public void push(String push) {
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

    // 자료 유무 확인
    boolean includes(String target) {
        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    // 인덱스 탐색
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


    // 강사님
//    // 인덱스 탐색 (indexOf)
//    public int indexOf(String target) {
//        for (int i = 0; i < sArr.length; i++) {
//            if (target.equals(sArr[i])) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    // 자료 유무 확인 (includes)
//    public boolean includes(String target) {
//        return indexOf(target) != -1;
//    }
//
//    // 중간 삭제 (remove) : 인덱스로 삭제
//    public String remove(int index) {
//        if (index < 0 || index > sArr.length - 1) return null;
//
//        String targetData = sArr[index];
//        for (int i = index; i < sArr.length - 1; i++) {
//            sArr[i] = sArr[i + 1];
//        }
//        pop();
//        return targetData;
//    }
//    // 중간 삭제 (remove) : 값으로 삭제
//    public String remove(String target) {
//        return remove(indexOf(target));
//    }
//
//    // 중간 삽입 (insert)
//    public void insert(int index, String newData) {
//
//        if (index < 0 || index > sArr.length - 1) return;
//        if (index == sArr.length - 1) push(newData);
//
//        String[] temp = new String[sArr.length + 1];
//        for (int i = 0; i < sArr.length; i++) {
//            temp[i] = sArr[i];
//        }
//        for (int i = temp.length - 1; i > index; i—) {
//            temp[i] = temp[i-1];
//        }
//        temp[index] = newData;
//        sArr = temp;
//    }

}
