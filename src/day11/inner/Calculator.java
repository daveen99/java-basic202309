package day11.inner;

// 이 인터페이스는 람다를 사용할 수 있는가?
// 람다사용조건 : 추상메서드가 단 하나여야만 가능
@FunctionalInterface  //  <<<<<<<<<<<<<<<
public interface Calculator {

    // 계산에 관련된 기능 명세
    // 두 개의 정수를 상황에 맞게 연산할 수 있다.
    int operate(int n1, int n2);

    // 이렇게 하면 안걸림
    default void abc() {}
}
