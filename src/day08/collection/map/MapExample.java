package day08.collection.map;

import day05.poly.car.Mustang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {

        // key의 타입, value의 타입
        Map<String, Object> map = new HashMap<>();

        // put(K, V) - 데이터 추가
        map.put("지갑잔액", 5000);
        map.put("좋아하는 자동차", new Mustang());
        map.put("저녁메뉴", "계란말이");

        System.out.println(map.size());

        // get(key)
        int money = (int) map.get("지갑잔액");
        String dinner = (String) map.get("저녁메뉴");

        // 중복된 키를 저장하면 값이 변경된다.
        map.put("저녁메뉴", "김치찌개");

        System.out.println(map);

        // map의 반복문 처리
        Set<String> set1 = map.keySet();
        System.out.println("set1 = " + set1);

        for (String s : set1) {
            System.out.printf("%s : %s\n", s, map.get(s));
        }
    }
}
