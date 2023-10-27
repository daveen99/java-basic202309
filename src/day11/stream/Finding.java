package day11.stream;

import java.util.Comparator;
import java.util.Optional;

import static java.util.Comparator.*;

public class Finding {

    public static void main(String[] args) {

        // 음식메뉴중에 채식주의자가 먹을 수 있는 요리가 있는가?
        boolean flag1 = Menu.menuList.stream()
                .anyMatch(Dish::isVegeterian);
        System.out.println(flag1);

        // 음식메뉴중에 칼로리가 50미만인 음식이 있는가?
        boolean flag2 = Menu.menuList.stream()
                .anyMatch(dish -> dish.getCalories() < 50);
        System.out.println(flag2);

        System.out.println("================");
        System.out.println();

        // 음식메뉴중에 모든 요리가 1000칼로리 미만입니까?
        boolean flag3 = Menu.menuList.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(flag3);

        // 음식메뉴중에 모든 요리가 1000칼로리 미만이 아닙니까?
        boolean flag4 = Menu.menuList.stream()
                .noneMatch(d -> d.getCalories() < 1000);
        System.out.println(flag4);

        // 음식중에 칼로리가 가장 낮은 음식을 조회
        Dish dish = Menu.menuList.stream()
                .min(comparing(Dish::getCalories))
                .get();
        System.out.println(dish);

//        min.ifPresent(d -> d.getCalories());
        // 만약에 존재하면 꺼내고 아니면 X (널포인터익셉션견제)

    }
}
