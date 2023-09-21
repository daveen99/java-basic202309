package day08.generic;

// 제네릭 개념: 여러 타입의 객체를 생성할 수 있게 해주는 문법이다.
public class Basket<F> {

    private F fruit;

    public F getFruit() {
        return fruit;
    }

    public void setFruit(F fruit) {
        this.fruit = fruit;
    }
}
