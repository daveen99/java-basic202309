package day11.stream;

import util.Utility;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Sorting {
    public static void main(String[] args) {

        // 음식목록 중 칼로리가 낮은 순으로 정렬
        Menu.menuList.stream()
                .sorted(comparing(Dish::getCalories))
                .collect(toList())
                .forEach(System.out::println);


        Utility.makeLine();

        // 칼로리 기준 내림차순
        Menu.menuList.stream()
                .sorted(comparing(Dish::getCalories).reversed())
                .collect(toList())
                .forEach(System.out::println);

        System.out.println();
        System.out.println();

        // 500 칼로리보다 큰 요리 중에 TOP3 필터링
        Menu.menuList.stream()
                .filter(d -> d.getCalories() > 500)
                .sorted(comparing(Dish::getCalories).reversed())
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);





    }
}
