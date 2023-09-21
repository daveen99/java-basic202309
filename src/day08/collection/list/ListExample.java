package day08.collection.list;

// 컬렉션들이 모여있는 패키지
import day03.fruit.Apple;
import util.Utility;

import java.util.*;

import static util.Utility.makeLine;

public class ListExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // add (E e) : 맨 끝에 데이터 추가.
        list.add("빠네");
        list.add("토매이러스빠게리");
        list.add("치퀸");

        System.out.println(list);

        // 중간삽입 add (index, E)
        list.add(2, "족발");
        System.out.println(list);

        int size = list.size();
        System.out.println("size = " + size);

        // indexOf(E e): 해당 데이터의 인덱스 반환    , lastIndexOf
        int index = list.indexOf("토매이러스빠게리");
        System.out.println("index = " + index);

        // contains(E e): 해당 데이터 저장 유무 반환
        System.out.println(list.contains("치퀸"));
        System.out.println(list.contains("양장피"));

        // remove(index) or remove(object)  인덱스번호나 오브젝트이름으로도 삭제가능
        list.remove("빠네");
        // list.remove(0);
        System.out.println("list = " + list);

        // set(index, newElement): 수정
        list.set(0, "동파육");
        System.out.println("list = " + list);

        // get(index): 리스트에 저장된 데이터 참조
        String s = list.get(1);
        System.out.println("s = " + s);

        // 반복문 처리
        makeLine();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        makeLine();
        for (String ss : list) {
            System.out.println("ss = " + ss);
        }

        // clear(): 전체삭제
        // isEmpty(): 리스트가 비어있는지 확인
        makeLine();
        System.out.println(list.isEmpty()); // flase
        list.clear();
        System.out.println(list.isEmpty()); // true

        // 리스트에 초기값 넣고 시작하기
        List<Integer> numbers = new ArrayList<>(
                List.of(5, 30, 7, 99, 3, 41)
//                Arrays.asList(5, 30, 99, 11, 3, 2)
        );

        makeLine();
        System.out.println(numbers);

        // 오름차 정렬 (퀵 정렬 )
        numbers.sort(Integer::compareTo);

        System.out.println(numbers);

        // 내림차 정렬
        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);

        // 배열리스트와 연결리스트
        /*
                          탐색속도    삽입삭제속도
             배열리스트      빠름         느림
             연결리스트      느림         빠름
         */

//        List<Apple> appleList = new ArrayList<>();  //배열리스트
        List<Apple> appleList = new LinkedList<>();  //연결리스트
        // 얘도 똑같이 add 쓴다.


    }
}
