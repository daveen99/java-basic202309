package day08.collection.set;

import day04.modi.pac1.A;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {

        // 빠른 저장 속도, 중복을 제거, 순서가 없다.
        // 인덱스나 키를 사용하지 않아서 개별탐색에는 불리하다.
        Set<String> foodSet = new HashSet<>();

        // add(E e): 데이터 추가
        boolean f1 = foodSet.add("김말이");

        foodSet.add("닭꼬치");
        foodSet.add("단무지");
        boolean f2 = foodSet.add("김말이");
        foodSet.add("김밥");

        System.out.println(foodSet.size());
        System.out.println(foodSet);
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        for (String s : foodSet) {
            System.out.println("s = " + s);
        }

        // remove(object)
        foodSet.remove("단무지");
        System.out.println(foodSet);

        // 데이터 중복을 빠르게 제거할 때
        List<Integer> numbers = new ArrayList<>(
                List.of(1,1,1,2,2,2,3,3,3,3,3,4,4,4,5,5)
        );
        System.out.println(numbers);

        
        // Set으로 변환
        Set<Integer> numberSet = new HashSet<>(numbers);
        System.out.println("numberSet = " + numberSet);

        // 다시 List로 변환
        numbers = new ArrayList<>(numberSet);
        System.out.println(numbers);
    }
}
