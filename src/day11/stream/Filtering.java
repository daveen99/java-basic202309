package day11.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static day11.stream.Dish.Type.*;
import static day11.stream.Menu.*;
import static java.util.stream.Collectors.*;

public class Filtering {

    public static void main(String[] args) {

        // stream의 filter
        // 필터조건에 맞는 데이터들을 필터링하여 리스트로 반환

        // 메뉴중에 채식주의자가 먹을 수 있는 요리를 필터링
//        List<Dish> dishInVegtarian = menuList.stream()
//                .filter(dish -> dish.isVegeterian())
//                .collect(Collectors.toList());
        //dishInVegtarian.forEach(dish -> System.out.println(dish));
        menuList.stream()
                .filter(dish1 -> dish1.isVegeterian())
                .collect(toList())
                .forEach(System.out::println);


        System.out.println("===== 육류이면서 600칼로리 미만 =====");
        menuList.stream()
                .filter(dish -> dish.getType() == MEAT
                && dish.getCalories() < 600)
                .collect(toList())
                .forEach(dish -> System.out.println(dish));

        System.out.println("\n===== 요리중에 이름이 4글자인 요리만 =====");
        menuList.stream()
                .filter(d -> d.getName().length() == 4)
                .collect(toList())
                .forEach(d -> System.out.println(d));


        System.out.println("\n===== 요리중에 300칼로리보다 큰것(초과) ====");
        menuList.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3) // TOP 3를 추출
                .collect(toList())
                .forEach(d -> System.out.println(d));


        System.out.println("====================");
        menuList.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)  // 맨 앞 2개를 제외시킴
                .collect(toList())
                .forEach(d -> System.out.println(d));



        System.out.println("\n====== 메뉴목록에서 처음 등장하는 " +
                            "2개의 생선요리 필터링 =====");
        menuList.stream()
                .filter(d -> d.getType() == FISH)
                .limit(2)
                .collect(toList())
                .forEach(d -> System.out.println(d));

        System.out.println();
        List<Integer> numbers = List.of(1,2,1,3,3,2,4,4,5,6);
        // 짝수만 필터링
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .collect(toList());
        System.out.println(filteredNumbers);

        // 중복제거
//        Set<Integer> distinctedNumbers = new HashSet<>(filteredNumbers);
//        System.out.println(distinctedNumbers);


    }
}
