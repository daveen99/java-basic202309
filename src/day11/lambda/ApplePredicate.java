package day11.lambda;

// 람다를 쓸수있는지 체크
@FunctionalInterface
public interface ApplePredicate {

    // 사과를 전달받으면 조건에 맞는 검사를 수행하는 메서드
    boolean test(Apple apple);
}
